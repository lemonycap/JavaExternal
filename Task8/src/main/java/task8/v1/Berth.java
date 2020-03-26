package task8.v1;

public class Berth {
  private int berthCapacity;
  private volatile int numberOfBerthContainers;
  private int numberOfBerth;
  volatile boolean isBusy;


    public Berth(int berthCapacity,int number) {
        isBusy = false;
        this.numberOfBerthContainers = Utils.generateRandomNumber(0,berthCapacity);
        this.berthCapacity = berthCapacity;
        this.numberOfBerth = number;
    }

    synchronized  void action () {
        while (isBusy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isBusy = true;
        System.out.println(Thread.currentThread().getName() + " in the berth " + getNumberOfBerth());
        int action = Utils.generateRandomNumber(1,2);
        switch (action) {
            case 1:
                get();
                break;
            case 2:
                put();
                break;
        }
        isBusy = false;
        notifyAll();
    }

      synchronized void get() {
        System.out.println("GET");
    }

       synchronized void put() {
         System.out.println("PUT");
    }

    public int getNumberOfBerth() {
        return numberOfBerth;
    }

    public int getBerthCapacity() {
        return berthCapacity;
    }
}
