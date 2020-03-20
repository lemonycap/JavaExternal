package com.example.parsers.sax;

import java.io.IOException;
import java.util.Set;

import candies.Candy;
import com.example.parsers.handler.CandyHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXBuilder {
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
