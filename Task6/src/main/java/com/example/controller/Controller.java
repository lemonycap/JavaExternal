package com.example.controller;

import com.example.parsers.builder.AbstractBuilder;
import com.example.parsers.factory.BuilderFactory;
import com.example.parsers.utils.Helper;
import com.example.validation.utils.ValidatingAnnotation;
import com.example.validation.utils.Validation;
import com.example.validation.ValidatorSAX;
import com.example.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Controller {
    View view;
    Command command;
    AbstractBuilder builder;


    public Controller(View view) {
        this.view = view;
    }

    public void processUser() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        validationMethod();
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

    public  void validationMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Validation validation = new Validation();
        validation.setValid(true);
        validateXML(validation);
    }

    public  void validateXML(Validation validation) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class valid = Validation.class;
        Method getValid = valid.getMethod( "isValid");
        boolean iget_valid = (boolean)getValid.invoke(validation);
        if( getValid.isAnnotationPresent(ValidatingAnnotation.class)) {
            ValidatingAnnotation initAnnotation = getValid.getAnnotation(ValidatingAnnotation.class);
            if (iget_valid == (initAnnotation.toValidate())) {
                ValidatorSAX.validateFile();
            }
            else {
                view.printMessage(View.NO_VALIDATION);
            }
        }
    }
}
