package com.example.controller;

import com.example.parsers.builder.AbstractBuilder;
import com.example.parsers.factory.BuilderFactory;
import com.example.parsers.utils.Helper;
import com.example.validation.ValidatorSAX;
import com.example.view.View;

public class Controller {
    View view;
    Command command;
    AbstractBuilder builder;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser() {
        ValidatorSAX.validateFile();
        while (true) {
            parseXML();
        }
    }


    public void parseXML() {
        view.printMessage(View.XML_PARSING);
        view.printMessage(View.CHOOSE_PARSER);
        BuilderFactory sFactory = new BuilderFactory();
        int chosenParser = Helper.measuresCheck(1,4);
        if (chosenParser == 1) {
            command = () -> {
                builder = sFactory.createBuilder("sax");
                builder.buildSetCandies("src/main/resources/data/Candies.xml");
                Helper.sortCandies(builder.getCandies());
            };
        }
        else if (chosenParser == 2) {
            command = () -> {
                builder = sFactory.createBuilder("stax");
                builder.buildSetCandies("src/main/resources/data/Candies.xml");
                Helper.sortCandies(builder.getCandies());
            };
        }
        else if (chosenParser == 3) {
            command = () -> {
                builder = sFactory.createBuilder("dom");
                builder.buildSetCandies("src/main/resources/data/Candies.xml");
                Helper.sortCandies(builder.getCandies());
            };
        }

        else {
            command = () -> {
                view.printMessage(View.EXIT);
                System.exit(0);
            };
        }
        command.execute();
    }
}
