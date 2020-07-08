package com.netopstec.webbackend.service;

import com.netopstec.webbackend.api.FoodListQueryRequest;
import com.netopstec.webbackend.dao.FoodRepository;
import com.netopstec.webbackend.entity.Food;
import com.netopstec.webbackend.util.PageUtil;
import com.netopstec.webbackend.util.PredicateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhenye 2020/5/7
 */
@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @SuppressWarnings(value = "unchecked")
    public Page<Food> selectList(FoodListQueryRequest foodListQueryRequest) {
        Specification querySpec = (Specification) (root, cq, cb) -> {
            List<Predicate> andPredicateList = new ArrayList<>();
            Predicate predicate1 = null, predicate2 = null;
            String inputName = foodListQueryRequest.getName();
            if (inputName != null) {
                Path name = root.get("name");
                predicate1 = cb.like(name, foodListQueryRequest.getName());
            }
            andPredicateList.add(predicate1);
            Date modifiedTimeStart = foodListQueryRequest.getModifiedTimeStart();
            Date modifiedTimeEnd = foodListQueryRequest.getModifiedTimeEnd();
            Path modifiedTime = root.get("modifiedTime");
            if (modifiedTimeStart != null && modifiedTimeEnd != null) {
                predicate2 = cb.between(modifiedTime, foodListQueryRequest.getModifiedTimeStart(), foodListQueryRequest.getModifiedTimeEnd());
            } else if (modifiedTimeStart != null) {
                predicate2 = cb.greaterThan(modifiedTime, modifiedTimeStart);
            } else if (modifiedTimeEnd != null) {
                predicate2 = cb.lessThan(modifiedTime, modifiedTimeEnd);
            }
            andPredicateList.add(predicate2);
            return PredicateUtil.toPredicate(cb, andPredicateList, null);
        };
        PageRequest pageRequest = PageUtil.initPage(foodListQueryRequest.getPageNo(), foodListQueryRequest.getPageSize(), foodListQueryRequest.getSort());
        return foodRepository.findAll(querySpec, pageRequest);
    }

    public Food getById(Long id) {
        return foodRepository.getOne(id);
    }

    public void save(Food food) {
        foodRepository.save(food);
    }
}
