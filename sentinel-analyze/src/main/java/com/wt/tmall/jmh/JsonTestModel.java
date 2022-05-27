package com.wt.tmall.jmh;

import lombok.Data;

/**
 * @author: wtt
 * @date: 2022/5/27 19:25
 * @description:
 */
@Data
public class JsonTestModel {
    private String startDate;
    private String endDate;
    private Boolean flag;
    private Integer threads;
    private Integer shardingIndex;
}
