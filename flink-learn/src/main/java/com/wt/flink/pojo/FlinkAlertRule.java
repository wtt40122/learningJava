package com.wt.flink.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Data
public class FlinkAlertRule implements Serializable {
    private Long ruleId;
    private String filterRegex;
    private Pattern pattern;
    private List<String> containsData;
    private List<String> notContainData;
    private String startWithStr;
    private String endWithStr;

    public FlinkAlertRule() {
    }
}
