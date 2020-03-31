package com.example.parsers.builder.sax;

import java.io.IOException;
import java.util.Set;

import com.example.model.candies.Candy;
import com.example.parsers.builder.AbstractBuilder;
import com.example.parsers.builder.sax.handler.CandyHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXBuilder extends AbstractBuilder {
    private Set<Candy> candies;
    private CandyHandler ch;
    private XMLReader reader;

    public SAXBuilder() {
// создание SAX-анализатора
        ch = new CandyHandler();
        try {
// создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ch);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }
    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String fileName) {
        try {
// разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        candies = ch.getCandies();
    }
}
