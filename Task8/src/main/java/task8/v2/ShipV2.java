package task8.v2;

import task8.v1.Utils;

import static task8.v2.MainV2.SEMAPHORE;

public class ShipV2 implements Runnable{

    private int shipNumber;
    private int numberOfContainers;
    public final static int CARRYING_CAPACITY = 5;

    BerthV2 berth;


    public ShipV2 (int i, BerthV2 berth) {
        this.berth = berth;
        this.shipNumber = i;
        numberOfContainers = Utils.generateRandomNumber(0,CARRYING_CAPACITY);
        new Thread(this,"Ship " + getShipNumber()).start();
    }

    public void run() {
        berth.action(shipNumber,numberOfContainers);
    }


    public int getShipNumber() {
        return shipNumber;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

}
