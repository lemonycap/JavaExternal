package task4.view;

import task4.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class View {

    public static final String SELECT_WORD_TO_SEARCH = "Select a word to search. ";
    public static final String VOCABULARY_SIZE = "At the moment vocabulary size is ";
    public static final String SELECT_WORD = "Please, enter a number of word: ";
    public static final String WRONG_INPUT = "Wrong input.Please, try again.";
    public static final String WORD_INFO = "Information, which was founded about this word: ";

    public static void printMessage (String message) {
        System.out.println(message);
    }

    public static void printMap () {
        for(Map.Entry<String, HashMap<String,Integer>> entry: Controller.mainContainer.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }

}
