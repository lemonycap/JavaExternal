package task8.v1;

public  class  Ship implements Runnable {
    private int shipNumber;
    private int numberOfContainers;
    public final static int CARRYING_CAPACITY = 5;

    Berth berth;


    public Ship (int i, Berth berth) {
        this.berth = berth;
        this.shipNumber = i;
        numberOfContainers = Utils.generateRandomNumber(0,CARRYING_CAPACITY);
        new Thread(this,"Ship " + getShipNumber()).start();
    }

    public void run() {
           berth.action(numberOfContainers);
        }


    public int getShipNumber() {
        return shipNumber;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

}
