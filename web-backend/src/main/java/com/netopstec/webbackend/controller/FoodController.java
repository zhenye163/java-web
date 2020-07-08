package com.netopstec.webbackend.controller;

import com.netopstec.webbackend.api.FoodListQueryRequest;
import com.netopstec.webbackend.entity.Food;
import com.netopstec.webbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhenye 2020/5/7
 */
@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/list")
    public Page<Food> selectList(FoodListQueryRequest request) {
        return foodService.selectList(request);
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable("id") Long id) {
        return foodService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Food food) {
        foodService.save(food);
    }
}
