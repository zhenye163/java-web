package com.netopstec.webbackend.dao;

import com.netopstec.webbackend.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhenye 2020/5/7
 */
public interface FoodRepository extends JpaRepository<Food, Long>, JpaSpecificationExecutor {
}
