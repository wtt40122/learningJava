package com.wt.learn;

import com.wt.learn.expr.ExprLexer;
import com.wt.learn.expr.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/7/8 16:27
 */
public class ExprJoyRide {

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream("(1+2)=");
        ExprLexer exprLexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(exprLexer);
        ExprParser parser = new ExprParser(tokens);
        ExprParser.ProgContext tree = parser.prog();
        System.out.println(tree.toInfoString(parser));
    }
}
