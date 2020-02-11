package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private int minValue = 0;
    private int maxValue = 100;
    private Model model;
    private View view;
    private ArrayList<Integer> statistics = new ArrayList<>();

    public Controller (View view) {
        this.model = new Model(minValue,maxValue);
        this.view = view;
    }

    public void userInteraction() throws Exception {
        System. out.println("Conceived number is: " + model.getConceivedNumber()); //to check if the program works correctly
        String locale = selectLanguage();
        Locale current = new Locale(locale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources",current);
        view.printMessage(new String(resourceBundle.getString("gameInfo").getBytes("ISO-8859-1"),"windows-1251"));
        //guessNumber(model.getConceivedNumber(),resourceBundle);
       guessNumberUsingBufferedReader(model.getConceivedNumber(),resourceBundle);
    }

    public String selectLanguage() {
        view.printMessage(view.LANGUAGE_CHOICE);
        Scanner sc = new Scanner(System.in);
        int number = measuresCheck(1,2);
        if (number == 1) {
            return "en";
        }
        else {
            return "ru";
        }
    }

    public void guessNumber(int correctAnswer,ResourceBundle rb) throws UnsupportedEncodingException {
        int stepCounter = 1;
        Scanner sc = new Scanner(System.in);
        int buffer = inputCheck(sc);
        while (buffer != correctAnswer) {
            stepCounter++;
            if ((buffer > maxValue) || (buffer < minValue)) {
                view.printMessage(new String((rb.getString("numberIsOutOfRange")
                        + rb.getString("rangeInfo")).getBytes("ISO-8859-1"),"windows-1251"));

            } else if (buffer < correctAnswer) {
                minValue = buffer;
                view.printMessage(new String((rb.getString("wrongAnswer")
                        + rb.getString("answerIsBigger")).getBytes("ISO-8859-1"),"windows-1251"));
                view.printMessage(new String(rb.getString("rangeInfo").getBytes("ISO-8859-1"),"windows-1251")
                                    + minValue + "-" + maxValue);
            } else {
                maxValue = buffer;
                view.printMessage(new String((rb.getString("wrongAnswer")
                        + rb.getString("answerIsSmaller")).getBytes("ISO-8859-1"),"windows-1251"));
                view.printMessage(new String(rb.getString("rangeInfo").getBytes("ISO-8859-1"),"windows-1251")
                        + minValue + "-" + maxValue);
            }
            statistics.add(buffer);
            buffer = inputCheck(sc);
        }
        statistics.add(buffer);
        view.printMessage(new String((rb.getString("winGameInfo")).getBytes("ISO-8859-1"),"windows-1251")
                + correctAnswer);
        view.printMessage(new String( rb.getString("userStatistics").getBytes("ISO-8859-1"),"windows-1251"));
        view.printMessage(new String(rb.getString("amountOfStepsInfo").getBytes("ISO-8859-1"),"windows-1251") + stepCounter);
        printStatistics(rb);
    }

    public void guessNumberUsingBufferedReader(int correctAnswer,ResourceBundle rb) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counterOfSteps = 1;
        int buff = inputCheckInBufferedReader(br,rb);
        while (buff != correctAnswer) {
            counterOfSteps++;
            if ((buff > maxValue) || (buff < minValue)) {
                view.printMessage(new String((rb.getString("numberIsOutOfRange")
                        + rb.getString("rangeInfo")).getBytes("ISO-8859-1"),"windows-1251"));

            } else if (buff < correctAnswer) {
                minValue = buff;
                view.printMessage(new String((rb.getString("wrongAnswer")
                        + rb.getString("answerIsBigger")).getBytes("ISO-8859-1"),"windows-1251"));
                view.printMessage(new String(rb.getString("rangeInfo").getBytes("ISO-8859-1"),"windows-1251")
                        + minValue + "-" + maxValue);
            } else {
                maxValue = buff;
                view.printMessage(new String((rb.getString("wrongAnswer")
                        + rb.getString("answerIsSmaller")).getBytes("ISO-8859-1"),"windows-1251"));
                view.printMessage(new String(rb.getString("rangeInfo").getBytes("ISO-8859-1"),"windows-1251")
                        + minValue + "-" + maxValue);
            }
            statistics.add(buff);
            buff = inputCheckInBufferedReader(br,rb);
        }
        statistics.add(buff);
        view.printMessage(new String((rb.getString("winGameInfo")).getBytes("ISO-8859-1"),"windows-1251")
                + correctAnswer);
        view.printMessage(new String( rb.getString("userStatistics").getBytes("ISO-8859-1"),"windows-1251"));
        view.printMessage(new String(rb.getString("amountOfStepsInfo").getBytes("ISO-8859-1"),"windows-1251") + counterOfSteps);
        printStatistics(rb);
    }

    public int inputCheckInBufferedReader(BufferedReader br, ResourceBundle rb) throws Exception {
        while (true) {
            try {
                String input = br.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.printMessage(new String(rb.getString("wrongInput").getBytes("ISO-8859-1"),"windows-1251"));
            }
        }
    }

    public int inputCheck(Scanner scanner)  {
        while (!scanner.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int measuresCheck(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number = inputCheck(sc);
        while (number > max || number < min) {
            //view.printMessage(bundle.getString("wrongInput"));
            number = inputCheck(sc);
        }
        return number;
    }


    public void printStatistics(ResourceBundle rb) throws UnsupportedEncodingException {
        int arraySize = statistics.size();
        for (int i = 0; i < arraySize; ++i) {
            System.out.println(new String(rb.getString("step").getBytes("ISO-8859-1"),"windows-1251")
                    + (i + 1) + ": " + statistics.get(i));
        }
    }
}
