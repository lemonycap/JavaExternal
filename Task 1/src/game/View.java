package game;

public class View {
    public static final String LANGUAGE_CHOICE = "Press 1 for game in English, 2 - for Russian.";
    public static final String GAME_INFO = "Try to guess the number conceived by a computer. The range is from 0 to 100";
    public static final String WRONG_ANSWER = "Wrong answer. Please, try again.";
    public static final String NUMBER_IS_OUT_OF_RANGE = "Number is out of range. Please,try again.";
    public static final String ANSWER_IS_SMALLER = "The answer is smaller.";
    public static final String ANSWER_IS_BIGGER = "The answer is bigger.";
    public static final String RANGE_INFO = "Now range is: ";
    public static final String WIN_GAME_INFO = "Congrats! You win! Conceived number is ";
    public static final String AMOUNT_OF_STEPS_INFO = "The amount of steps you have taken: ";
    public static final String USER_STATISTICS = "Statistics of the game: ";
    public static final String WRONG_INPUT = "Wrong input data. Enter an integer number.";

    public static void printMessage (String message) {
        System.out.println(message);
    }
}
