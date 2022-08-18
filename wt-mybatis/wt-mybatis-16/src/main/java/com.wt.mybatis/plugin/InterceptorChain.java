package com.wt.mybatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/18 10:33
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors(){
        return Collections.unmodifiableList(interceptors);
    }

}
