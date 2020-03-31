package com.example.view;

public class View {
    public static final String XML_PARSING = "Xml parsing:";
    public static final String CHOOSE_PARSER  = "Choose parser: " + " \"1 - SAX, 2 - StAX, 3 - DOM, 4 - Exit\"";
    public static final String WRONG_INPUT = "Wrong input. Try again.";
    public static final String EXIT = "You successfully exited.";
    public static final String NO_VALIDATION = "Program will be executed without XML validation.";


    public static void printMessage(String message) {
        System.out.println(message);
    }
}
