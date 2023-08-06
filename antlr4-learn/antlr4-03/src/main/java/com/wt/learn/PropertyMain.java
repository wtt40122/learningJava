package com.wt.learn;

import com.wt.learn.property.PropertyFileLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/8/6 13:13
 */
public class PropertyMain {
    public static void main(String[] args) {
        String str = "key=\"value\"";
        ANTLRInputStream input = new ANTLRInputStream(str);

        PropertyFileLexer propertyFileLexer = new PropertyFileLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(propertyFileLexer);
        PropertyFilePrinter propertyFilePrinter = new PropertyFilePrinter(commonTokenStream);
        propertyFilePrinter.file();
    }
}
