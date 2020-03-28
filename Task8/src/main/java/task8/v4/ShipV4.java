package task8.v4;

import task8.v1.Utils;

public class ShipV4 implements Runnable {
    private int shipNumber;
    private int numberOfContainers;
    public final static int CARRYING_CAPACITY = 5;

    BerthV4 berth;

    public ShipV4 (int i, BerthV4 berth) {
        this.berth = berth;
        this.shipNumber = i;
        numberOfContainers = Utils.generateRandomNumber(CARRYING_CAPACITY - 1,CARRYING_CAPACITY);
        new Thread(this,"Ship " + getShipNumber()).start();
    }

    public void run() {
        try {
            berth.action(shipNumber,numberOfContainers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int getShipNumber() {
        return shipNumber;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }
}
