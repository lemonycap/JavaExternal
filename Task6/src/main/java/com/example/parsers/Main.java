package com.example.parsers;

import com.example.parsers.sax.SAXBuilder;
import com.example.parsers.utils.Helper;

public class Main {
    public static void main (String [] args) {
        System.out.println("Work with SAX parser:");
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.buildSetCandies("src/main/resources/data/Candies.xml");
        System.out.println(saxBuilder.getCandies());
        Helper.printCandies(saxBuilder.getCandies());

        System.out.println("Work with DOM parser:");
        DOMBuilder domBuilder = new DOMBuilder();
        domBuilder.buildSetCandies("src/main/resources/data/Candies.xml");
        System.out.println(domBuilder.getCandies());
        Helper.printCandies(domBuilder.getCandies());
    }
}
