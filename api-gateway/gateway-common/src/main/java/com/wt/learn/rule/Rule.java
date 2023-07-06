package com.wt.learn.rule;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: wtt
 * @Date: 2023/7/5 22:51
 * @Version: 1.0
 * @Description:
 */
@Data
@EqualsAndHashCode
public class Rule implements Comparable<Rule>, Serializable {

    @EqualsAndHashCode.Include
    private String id;
    private String name;

    private String protocol;

    private Integer order;

    private Set<FilterConfig> filterConfigs = new HashSet<>();


    public Rule() {
        super();
    }

    public Rule(String id, String name, String protocol, Integer order, Set<FilterConfig> filterConfigs) {
        this.id = id;
        this.name = name;
        this.protocol = protocol;
        this.order = order;
        this.filterConfigs = filterConfigs;
    }


    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class FilterConfig {
        private String id;
        private String config;

    }


    public void addFilterConfig(FilterConfig config) {
        this.filterConfigs.add(config);
    }

    public FilterConfig getFilterConfig(String id) {
        return filterConfigs.stream()
                .filter(config -> Objects.equals(id, config.getId()))
                .findFirst().orElse(null);
    }

    public boolean hashId(String id) {
        for (FilterConfig config : filterConfigs) {
            if (Objects.equals(id, config.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Rule o) {
        int compareOrder = Integer.compare(getOrder(), o.getOrder());
        if (0 == compareOrder) {
            return getId().compareTo(o.getId());
        }
        return compareOrder;
    }
}
