package com.wt.learn;

import com.wt.learn.property.PropertyFileParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/8/6 13:23
 */
public class PropertyFileLoader extends PropertyFileParser {

    Map<String, String> props = new HashMap<>();

    public PropertyFileLoader(TokenStream input) {
        super(input);
    }

    @Override
    public void defineProperty(Token name, Token value) {
        props.put(name.getText(), value.getText());
    }
}
