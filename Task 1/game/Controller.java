package game;

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

    public void userInteraction() {
        view.printMessage(view.GAME_INFO);
        System. out.println("Conceived number is: " + model.getConceivedNumber()); //to check if the program works correctly
        guessNumber(model.getConceivedNumber());
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
