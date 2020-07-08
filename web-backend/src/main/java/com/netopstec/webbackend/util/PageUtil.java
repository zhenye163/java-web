package com.netopstec.webbackend.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * JPA分页参数封装工具类
 * @author zhenye 2020/5/8
 */
public class PageUtil {

    /**
     * 分页参数封装
     */
    public static PageRequest initPage(Integer pageNo, Integer pageSize) {
        return PageRequest.of(pageNo - 1, pageSize);
    }

    /**
     * 分页参数以及排序参数封装，默认是升序
     */
    public static PageRequest initPage(Integer pageNo, Integer pageSize, String sortField) {
        if (sortField == null) {
            return initPage(pageNo, pageSize);
        }
        return initPage(pageNo, pageSize, sortField, true);
    }

    /**
     * 分页参数封装
     */
    public static PageRequest initPage(Integer pageNo, Integer pageSize, String sortField, Boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortField);
        return PageRequest.of(pageNo - 1, pageSize, sort);
    }
}
