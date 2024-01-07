package com.wt.learn.web;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wtt
 * @Date: 2023/12/31 12:27
 * @Version: 1.0
 * @Description:
 */
public class XmlConfigReader {

    public Map<String, MappingValue> loadConfig(Resource res) {
        Map<String, MappingValue> mappings = new HashMap<>();
        while (res.hasNext()) {
            //读所有的节点，解析id, class和value
            Element element = (Element) res.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            String beanMethod = element.attributeValue("value");
            mappings.put(beanID, new MappingValue(beanID, beanClassName, beanMethod));
        }
        return mappings;
    }
}
