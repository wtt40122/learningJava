package com.wt.learn;

import com.wt.learn.property.PropertyFileParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/8/6 13:10
 */
public class PropertyFilePrinter extends PropertyFileParser {
    public PropertyFilePrinter(TokenStream input) {
        super(input);
    }

    @Override
    public void defineProperty(Token name, Token value) {
        System.out.println(name.getText() + "=" + value.getText());
    }
}
