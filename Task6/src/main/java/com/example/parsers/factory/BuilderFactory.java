package com.example.parsers.factory;

import com.example.parsers.builder.AbstractBuilder;
import com.example.parsers.builder.dom.DOMBuilder;
import com.example.parsers.builder.sax.SAXBuilder;
import com.example.parsers.builder.stax.StAXBuilder;

public class BuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractBuilder createBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMBuilder();
            case STAX:
                return new StAXBuilder();
            case SAX:
                return new SAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
