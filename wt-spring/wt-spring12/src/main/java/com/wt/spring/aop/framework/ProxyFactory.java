package com.wt.spring.aop.framework;

import com.wt.spring.aop.AdvisedSupported;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:14
 */
public class ProxyFactory {

    private AdvisedSupported advisedSupported;

    public ProxyFactory(AdvisedSupported advisedSupported) {
        this.advisedSupported = advisedSupported;
    }

    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        if (advisedSupported.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupported);
        }
        return new JdkDynamicAopProxy(advisedSupported);
    }
}
