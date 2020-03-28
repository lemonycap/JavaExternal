package task8.v3;

import task8.v1.Utils;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class PortV3 {
    private static final int AMOUNT_OF_BERTHS = 3;
    private static final int AMOUNT_OF_SHIPS = 15;
    private static final int CAPACITY = 50;
    private static ArrayList<BerthV3> berths = new ArrayList<BerthV3>();
    private int amountOfPortContainers;

    public PortV3() {
        createBerths();
        amountOfPortContainers = Utils.generateRandomNumber(CAPACITY,CAPACITY * 2);
        createShips();
    }

    public static void createBerths() {
        for (int i = 0; i < AMOUNT_OF_BERTHS; i++) {
            berths.add(new BerthV3(CAPACITY/AMOUNT_OF_BERTHS,i));
        }
    }

    public static void createShips() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(AMOUNT_OF_SHIPS);
        IntStream.range(0,AMOUNT_OF_SHIPS).forEach(i -> {
            int berthNumber = Utils.generateRandomNumber(0,berths.size());
            executor.execute(new ShipV3(i,berths.get(berthNumber)));
        });
        executor.shutdown();
    }

}
