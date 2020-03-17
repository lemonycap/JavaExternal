package task4.utils;

import task4.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHelpers {
    public static int inputCheckInBufferedReader(BufferedReader br) throws Exception {
        while (true) {
            try {
                String input = br.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                View.printMessage(View.WRONG_INPUT);
            }
        }
    }

    public static int measuresCheck(int min, int max) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = inputCheckInBufferedReader(br);
        while (number > max || number < min) {
            View.printMessage(View.WRONG_INPUT);
            View.printMessage(View.VOCABULARY_SIZE);
            number = inputCheckInBufferedReader(br);
        }
        return number;
    }
}
