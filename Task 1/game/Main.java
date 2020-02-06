package game;


import java.io.IOException;

public class Main {
    public static void main(String [] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.printMessage(view.USER_STATISTICS);
        try {
            controller.userInteraction();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
