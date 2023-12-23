package com.wt.learn.core.env;

/**
 * @Author: wtt
 * @Date: 2023/12/23 17:46
 * @Version: 1.0
 * @Description:
 */
public interface Environment extends PropertyResolver {
    String[] getActiveProfiles();

    String[] getDefaultProfiles();

    boolean acceptsProfiles(String... profiles);
}
