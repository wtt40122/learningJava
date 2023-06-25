package com.wt.flink.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FlinkRuleEvent implements Serializable {
    private List<FlinkAlertRule> alertRules;
    private Long alertId;
    private Long actionTime;

    public FlinkRuleEvent() {

    }

    public FlinkRuleEvent(long alertId) {
        this.alertId = alertId;
    }
}
