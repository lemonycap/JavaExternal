package com.example.parsers;

import com.example.parsers.builder.AbstractBuilder;
import com.example.parsers.factory.BuilderFactory;
import com.example.parsers.utils.Helper;

public class Main {
    public static void main (String [] args) {
        System.out.println("Work with XML:");
        BuilderFactory sFactory = new BuilderFactory();
        AbstractBuilder builder = sFactory.createBuilder("dom");
        builder.buildSetCandies("src/main/resources/data/Candies.xml");
        System.out.println(builder.getCandies());
        Helper.sortCandies(builder.getCandies());
    }
}
