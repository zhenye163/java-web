package com.netopstec.webbackend.dao;

import com.netopstec.webbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhenye 2020/6/4
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
