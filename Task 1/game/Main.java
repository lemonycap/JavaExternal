package game;

import game.Controller;

public class Main {
    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.printMessage(view.USER_STATISTICS);
        controller.userInteraction();
    }
}
