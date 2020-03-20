package com.example.parsers;

import com.example.parsers.sax.SAXBuilder;
import com.example.parsers.utils.Helper;

public class Main {
    public static void main (String [] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        saxBuilder.buildSetCandies("src/main/resources/data/Candies.xml");
        System.out.println(saxBuilder.getCandies());
        Helper.printCandies(saxBuilder.getCandies());
    }
}
