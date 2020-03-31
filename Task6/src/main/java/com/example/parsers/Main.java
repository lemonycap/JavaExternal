package com.example.parsers;

import com.example.controller.Controller;
import com.example.view.View;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main (String [] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
