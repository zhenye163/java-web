package com.netopstec.webbackend.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zhenye 2020/5/8
 */
@Getter
@Setter
@ToString
public class PageQuery {
    @NotNull
    @Min(1)
    private Integer pageNo;

    @NotNull
    @Min(1)
    private Integer pageSize;

    private String sort;
}
