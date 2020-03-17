package task4;

import task4.controller.Controller;
import task4.view.View;


/** Task4.Написать поисковый сервис Shakespeare. По указаному слову найти все URL упорядоченые по возрастанию частоты слова.
 */

public class Main {
    public static void main (String []args)  {
        View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
