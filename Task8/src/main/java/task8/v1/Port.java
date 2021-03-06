package task8.v1;


import java.util.ArrayList;

public class Port {
    private static final int AMOUNT_OF_BERTHS = 3;
    private static final int AMOUNT_OF_SHIPS = 15;
    private static final int CAPACITY = 50;
    private static ArrayList<Berth> berths = new ArrayList<Berth>();
    private int amountOfPortContainers;



    public Port() {
        createBerths();
        amountOfPortContainers = Utils.generateRandomNumber(CAPACITY,CAPACITY * 2);
        createShips();
    }

    public static ArrayList<Berth> getBerths() {
        return berths;
    }

    public static void createBerths() {
        for (int i = 0; i < AMOUNT_OF_BERTHS; i++) {
            berths.add(new Berth(CAPACITY/AMOUNT_OF_BERTHS,i));
        }
    }

    public static void createShips() {
        for (int i = 0; i < AMOUNT_OF_SHIPS; i++) {
            int berthNumber = Utils.generateRandomNumber(0,berths.size());
            new Ship(i,berths.get(berthNumber));
        }
    }

    public int getAmountOfPortContainers() {
        return amountOfPortContainers;
    }
}
