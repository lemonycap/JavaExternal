package task8.v3;

import task8.v1.Utils;


public class BerthV3 {
    private int berthCapacity;
    private  int numberOfBerthContainers;
    private int numberOfBerth;

    public BerthV3(int berthCapacity,int number) {
        this.numberOfBerthContainers = Utils.generateRandomNumber(0,berthCapacity);
        this.berthCapacity = berthCapacity;
        this.numberOfBerth = number;
    }

    public  void action (int amountOfContainersOnShip) {

        System.out.println(Thread.currentThread().getName() + " in the berth " + getNumberOfBerth()
                + " containers: " + numberOfBerthContainers);
        if (amountOfContainersOnShip == ShipV3.CARRYING_CAPACITY || numberOfBerthContainers == 0) {
            get(amountOfContainersOnShip);
        } else if (numberOfBerthContainers == berthCapacity) {
            put(amountOfContainersOnShip);
        } else {
            get(amountOfContainersOnShip);
            put(amountOfContainersOnShip);
        }
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
        if ((numberOfBerthContainers - (ShipV3.CARRYING_CAPACITY - containersOnShip)) > 0) {
            return ShipV3.CARRYING_CAPACITY - containersOnShip;
        }
        else if (numberOfBerthContainers == 0) {
            return 0;
        }
        else if ((numberOfBerthContainers - ((ShipV3.CARRYING_CAPACITY - containersOnShip) - numberOfBerthContainers)) > 0) {
            return ((ShipV3.CARRYING_CAPACITY - containersOnShip) - numberOfBerthContainers);
        }
        return 0;
    }
}
