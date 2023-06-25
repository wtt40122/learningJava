package com.wt.flink.pojo;

import lombok.Data;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/6/25 10:07
 */
@Data
public class AlarmParam {
    private String accessKey;
    private String secretKey;
    private String producerAccessKey;
    private String producerSecretKey;
    private Long alertId;
    private String consumerServer;
    private String producerServer;
    private String consumerTopic;
    private String producerTopic;
    private String consumerGroup;
    private String producerGroup;
    private String consumerTag;
    private String mqType;
    private int windowSize;
    private int windowOffset;
    private String alertRulesInput;
    private Integer parallelism;
    private Integer userSet;
}
