package task8.v3;

import task8.v1.Utils;

import static task8.v2.MainV2.SEMAPHORE;


public class ShipV3 implements Runnable {
    private int shipNumber;
    private int numberOfContainers;
    public final static int CARRYING_CAPACITY = 5;

    BerthV3 berth;

    public ShipV3 (int i, BerthV3 berth) {
        this.berth = berth;
        this.shipNumber = i;
        numberOfContainers = Utils.generateRandomNumber(0,CARRYING_CAPACITY);
    }

    public void run() {
        berth.action(numberOfContainers);
        System.out.println("SHIP " + getShipNumber() + " LEFT THE BERTH");
    }

    public int getShipNumber() {
        return shipNumber;
    }

}
