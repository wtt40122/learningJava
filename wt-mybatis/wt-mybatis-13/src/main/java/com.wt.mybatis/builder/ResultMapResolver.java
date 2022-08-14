package com.wt.mybatis.builder;

import com.wt.mybatis.mapping.ResultMap;
import com.wt.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * @author: wtt
 * @date: 2022/8/14 10:52
 * @description:
 */
public class ResultMapResolver {
    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }

}
