package task8.v1;

public class Berth {
  private int berthCapacity;
  private  int numberOfBerthContainers;
  private int numberOfBerth;
  volatile boolean isBusy;


    public Berth(int berthCapacity,int number) {
        isBusy = false;
        this.numberOfBerthContainers = Utils.generateRandomNumber(0,berthCapacity);
        this.berthCapacity = berthCapacity;
        this.numberOfBerth = number;
    }

    synchronized  void action (int amountOfContainersOnShip) {
        while (isBusy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isBusy = true;
        System.out.println(Thread.currentThread().getName() + " in the berth " + getNumberOfBerth() + " containers: " + numberOfBerthContainers);
        int action = Utils.generateRandomNumber(1,2);
        if (amountOfContainersOnShip == Ship.CARRYING_CAPACITY || numberOfBerthContainers == 0) {
            get(amountOfContainersOnShip);
        }
        else if (numberOfBerthContainers == berthCapacity) {
            put(amountOfContainersOnShip);
        }
        else {
            get(amountOfContainersOnShip);
            put(amountOfContainersOnShip);
        }
        isBusy = false;
        notifyAll();
    }

       void get(int amountOfContainersOnShip) {
        int number = countAmountToUnload(amountOfContainersOnShip);
        numberOfBerthContainers += number;
        System.out.println(number + " NEW CONTAINERS. TOTAL: " + numberOfBerthContainers);
    }

        void put(int amountOfContainersOnShip) {
            int number = containersToLoad(amountOfContainersOnShip);
            numberOfBerthContainers -= number;
            System.out.println(number + " - SENT CONTAINERS. TOTAL: " + numberOfBerthContainers);
    }

    public int getNumberOfBerth() {
        return numberOfBerth;
    }

    public int getBerthCapacity() {
        return berthCapacity;
    }

    public int countAmountToUnload(int containersOnShip) {
        if ((numberOfBerthContainers + containersOnShip) > berthCapacity) {
           return  containersOnShip - (containersOnShip - (berthCapacity - numberOfBerthContainers));
        }
        return containersOnShip;
    }

    public int containersToLoad(int containersOnShip) {
        if ((numberOfBerthContainers - (Ship.CARRYING_CAPACITY - containersOnShip)) > 0) {
            return Ship.CARRYING_CAPACITY - containersOnShip;
        }
        else if (numberOfBerthContainers == 0) {
            return 0;
        }
       else if ((numberOfBerthContainers - ((Ship.CARRYING_CAPACITY - containersOnShip) - numberOfBerthContainers)) > 0) {
           return ((Ship.CARRYING_CAPACITY - containersOnShip) - numberOfBerthContainers);
        }
       return 0;
    }
}
