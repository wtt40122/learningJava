package com.wt.learn.init;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/7/4 20:01
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        System.out.println("tste");
        //新建一个CharStream,从标准输入读取数据
        ANTLRInputStream input = new ANTLRInputStream("{1,3,{4,5},6}");
        //新建一个词法分析器，处理输入的CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        //新建一个词法符号的缓冲区，用于存储词法分析器将生成的词法符号
        CommonTokenStream token = new CommonTokenStream(lexer);
        // 新建一个词法分析器，处理词法符号缓冲区中的内容
        ArrayInitParser parser = new ArrayInitParser(token);
        // 针对init规则,开始词法分析
        ArrayInitParser.InitContext tree = parser.init();
        // 用LISP风格打印生成的树
        System.out.println(tree.toString(parser));
    }
}
