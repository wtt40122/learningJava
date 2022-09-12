package com.wt.spring.context.annoation;

import cn.hutool.core.util.ClassUtil;
import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/12 19:20
 */
public class ClasspathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
