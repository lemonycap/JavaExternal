package game;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        view.printMessage(view.GAME_INFO);
        System. out.println("Conceived number is: " + model.getConceivedNumber()); //to check if the program works correctly
      // guessNumber(model.getConceivedNumber());
       guessNumberUsingBufferedReader(model.getConceivedNumber());
    }

    public void guessNumber(int correctAnswer) {
        int stepCounter = 1;
        Scanner sc = new Scanner(System.in);
        int buffer = inputCheck(sc);
        while (buffer != correctAnswer) {
            stepCounter++;
            if ((buffer > maxValue) || (buffer < minValue))
                view.printMessage(view.NUMBER_IS_OUT_OF_RANGE + view.RANGE_INFO + minValue + "-" + maxValue);

            else if (buffer < correctAnswer) {
                minValue = buffer;
                view.printMessage(view.WRONG_ANSWER + view.ANSWER_IS_BIGGER);
                view.printMessage(view.RANGE_INFO + minValue + "-" + maxValue);
            }
            else {
                maxValue = buffer;
                view.printMessage(view.WRONG_ANSWER + view.ANSWER_IS_SMALLER);
                view.printMessage(view.RANGE_INFO + minValue + "-" +  maxValue);
            }
            statistics.add(buffer);
            buffer = inputCheck(sc);
        }
        statistics.add(buffer);
        view.printMessage(view.WIN_GAME_INFO + view.USER_STATISTICS);
        //view.printMessage(view.USER_STATISTICS);
        view.printMessage(view.AMOUNT_OF_STEPS_INFO + stepCounter);
        printStatistics();
    }

    public void guessNumberUsingBufferedReader(int correctAnswer) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counterOfSteps = 1;
        int buff = inputCheckInBufferedReader(br);
        while (buff != correctAnswer) {
            counterOfSteps++;
            if ((buff > maxValue) || (buff < minValue))
                view.printMessage(view.NUMBER_IS_OUT_OF_RANGE + view.RANGE_INFO + minValue + "-" + maxValue);

            else if (buff < correctAnswer) {
                minValue = buff;
                view.printMessage(view.WRONG_ANSWER + view.ANSWER_IS_BIGGER);
                view.printMessage(view.RANGE_INFO + minValue + "-" + maxValue);
            }
            else {
                maxValue = buff;
                view.printMessage(view.WRONG_ANSWER + view.ANSWER_IS_SMALLER);
                view.printMessage(view.RANGE_INFO + minValue + "-" +  maxValue);
            }
            statistics.add(buff);
            buff = inputCheckInBufferedReader(br);
        }
        statistics.add(buff);
        view.printMessage(view.WIN_GAME_INFO + view.USER_STATISTICS);
        //view.printMessage(view.USER_STATISTICS);
        view.printMessage(view.AMOUNT_OF_STEPS_INFO + counterOfSteps);
        printStatistics();
    }

    public int inputCheckInBufferedReader(BufferedReader br) throws Exception {
       int parsedInput = 0;
        while (true) {
            try {
                String input = br.readLine();
                parsedInput = Integer.parseInt(input);
                return parsedInput;
            } catch (NumberFormatException e) {
                view.printMessage(view.WRONG_INPUT);
            }
        }
    }

    public int inputCheck(Scanner scanner)  {
        int number;
        while (!scanner.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT);
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }

    public void printStatistics() {
        for (int i = 0; i < statistics.size(); ++i) {
            System.out.println("Step " + (i + 1) + ": " + statistics.get(i));
        }
    }
}
