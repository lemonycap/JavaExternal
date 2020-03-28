package task8.v4;

import task8.v1.Utils;
import java.util.ArrayList;

public class PortV4 {
    private static final int AMOUNT_OF_BERTHS = 3;
    private static final int AMOUNT_OF_SHIPS = 15;
    private static final int CAPACITY = 50;
    private static ArrayList<BerthV4> berths = new ArrayList<BerthV4>();
    private int amountOfPortContainers;


    public PortV4() {
        createBerths();
        amountOfPortContainers = Utils.generateRandomNumber(CAPACITY,CAPACITY * 2);
        createShips();
    }

    public static void createBerths() {
        for (int i = 0; i < AMOUNT_OF_BERTHS; i++) {
            berths.add(new BerthV4(CAPACITY/AMOUNT_OF_BERTHS,i));
        }
    }

    public static void createShips() {
        for (int i = 0; i < AMOUNT_OF_SHIPS; i++) {
            int berthNumber = Utils.generateRandomNumber(0,berths.size());
            new ShipV4(i,berths.get(berthNumber));
        }
    }
}
