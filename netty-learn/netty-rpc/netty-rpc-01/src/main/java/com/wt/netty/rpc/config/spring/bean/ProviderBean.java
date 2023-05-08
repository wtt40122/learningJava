package com.wt.netty.rpc.config.spring.bean;

import com.wt.netty.rpc.config.ProviderConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:32
 */
public class ProviderBean extends ProviderConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //发布生产者
        doExport();
    }
}
