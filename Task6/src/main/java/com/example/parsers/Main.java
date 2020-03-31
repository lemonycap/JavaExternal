package com.example.parsers;

import com.example.controller.Controller;
import com.example.view.View;

public class Main {
    public static void main (String [] args) {
       View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
