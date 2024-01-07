package com.wt.learn.web;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * @Author: wtt
 * @Date: 2023/12/31 12:23
 * @Version: 1.0
 * @Description:
 */
public class ClassPathXmlResource implements Resource {

    private Document document;
    private Element element;
    private Iterator<Element> iterator;

    public ClassPathXmlResource(URL xmlPath) {
        SAXReader saxReader = new SAXReader();
        try {
            this.document = saxReader.read(xmlPath);
            this.element = document.getRootElement();
            this.iterator = element.elementIterator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        return iterator.next();
    }
}
