package com.wt.mybatis.builder.xml;

import com.wt.mybatis.builder.BaseBuilder;
import com.wt.mybatis.builder.MapperBuilderAssistant;
import com.wt.mybatis.builder.ResultMapResolver;
import com.wt.mybatis.io.Resources;
import com.wt.mybatis.mapping.ResultFlag;
import com.wt.mybatis.mapping.ResultMap;
import com.wt.mybatis.mapping.ResultMapping;
import com.wt.mybatis.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description XML映射构建器
 * @date 2022/8/2 19:59
 */
public class XMLMapperBuilder extends BaseBuilder {

    private Element element;
    // 映射器构建助手
    private MapperBuilderAssistant builderAssistant;
    private String resource;

    public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource) throws DocumentException {
        this(new SAXReader().read(inputStream), configuration, resource);
    }

    private XMLMapperBuilder(Document document, Configuration configuration, String resource) {
        super(configuration);
        this.builderAssistant = new MapperBuilderAssistant(configuration, resource);
        this.element = document.getRootElement();
        this.resource = resource;
    }

    /**
     * 解析
     */
    public void parse() throws Exception {
        // 如果当前资源没有加载过再加载，防止重复加载
        if (!configuration.isResourceLoaded(resource)) {
            configurationElement(element);
            // 标记一下，已经加载过了
            configuration.addLoadedResource(resource);
            // 绑定映射器到namespace Mybatis 源码方法名 -> bindMapperForNamespace
            configuration.addMapper(Resources.classForName(builderAssistant.getCurrentNamespace()));
        }
    }

    // 配置mapper元素
    // <mapper namespace="org.mybatis.example.BlogMapper">
    //   <select id="selectBlog" parameterType="int" resultType="Blog">
    //    select * from Blog where id = #{id}
    //   </select>
    // </mapper>
    private void configurationElement(Element element) {
        // 1.配置namespace
        String namespace = element.attributeValue("namespace");
        if (namespace.equals("")) {
            throw new RuntimeException("Mapper's namespace cannot be empty");
        }
        builderAssistant.setCurrentNamespace(namespace);
        // 2.解析ResultMap
        resultMapElements(element.elements("resultMap"));
        // 3.配置select|insert|update|delete
        buildStatementFromContext(element.elements("select"),
                element.elements("insert"),
                element.elements("update"),
                element.elements("delete"));
    }

    private void resultMapElements(List<Element> elements) {
        for (Element element : elements) {
            try {
                resultMapElement(element, Collections.emptyList());
            } catch (Exception e) {
            }
        }
    }

    private ResultMap resultMapElement(Element resultMapNode, List<ResultMapping> additionalResultMappings)
            throws Exception {
        String id = resultMapNode.attributeValue("id");
        String type = resultMapNode.attributeValue("type");
        Class<?> typeClass = resolveClass(type);
        List<ResultMapping> resultMappings = new ArrayList<>();
        resultMappings.addAll(additionalResultMappings);
        List<Element> resultChildren = resultMapNode.elements();
        for (Element resultChild : resultChildren) {
            List<ResultFlag> flags = new ArrayList<>();
            if ("id".equals(resultChild.getName())) {
                flags.add(ResultFlag.ID);
            }
            // 构建 ResultMapping
            resultMappings.add(buildResultMappingFromContext(resultChild, typeClass, flags));
        }

        // 创建结果映射解析器
        ResultMapResolver resultMapResolver = new ResultMapResolver(builderAssistant, id, typeClass, resultMappings);
        return resultMapResolver.resolve();
    }

    // 配置select|insert|update|delete
    private void buildStatementFromContext(List<Element>... lists) {
        for (List<Element> list : lists) {
            for (Element element : list) {
                final XMLStatementBuilder statementParser = new XMLStatementBuilder(configuration, builderAssistant, element);
                statementParser.parseStatementNode();
            }
        }
    }


    /**
     * <id column="id" property="id"/>
     * <result column="activity_id" property="activityId"/>
     */
    private ResultMapping buildResultMappingFromContext(Element context, Class<?> resultType, List<ResultFlag> flags) throws Exception {
        String property = context.attributeValue("property");
        String column = context.attributeValue("column");
        return builderAssistant.buildResultMapping(resultType, property, column, flags);
    }

}
