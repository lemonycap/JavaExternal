package task8.v4;

import task8.v1.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class BerthV4 {
    private int berthCapacity;
    private  int numberOfBerthContainers;
    private int numberOfBerth;

    ReentrantLock lock = new ReentrantLock();
    Condition emptyBerth = lock.newCondition();

    public BerthV4(int berthCapacity,int number) {
        this.numberOfBerthContainers = Utils.generateRandomNumber(0,berthCapacity);
        this.berthCapacity = berthCapacity;
        this.numberOfBerth = number;
    }

    public  void action (int number,int amountOfContainersOnShip) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " in the berth " + getNumberOfBerth()
                    + " containers: " + numberOfBerthContainers);
            if (amountOfContainersOnShip == ShipV4.CARRYING_CAPACITY) {
                get(amountOfContainersOnShip);
            }
            else if (numberOfBerthContainers == berthCapacity) {
                put(amountOfContainersOnShip);
            }
            else {
                put(amountOfContainersOnShip);
                get(amountOfContainersOnShip);
            }
               System.out.println("SHIP " + number + " LEFT THE BERTH");

        }

    void get(int amountOfContainersOnShip) throws InterruptedException {
        try {
            lock.lock();
            int number = countAmountToUnload(amountOfContainersOnShip);
            numberOfBerthContainers += number;
            System.out.println(number + " NEW CONTAINERS. TOTAL: " + numberOfBerthContainers);
            emptyBerth.signalAll();
        } finally {
            lock.unlock();
        }

    }

    void put(int amountOfContainersOnShip) throws InterruptedException {
        try {
            lock.lock();
            int number = containersToLoad(amountOfContainersOnShip);
            while (numberOfBerthContainers == 0 || amountOfContainersOnShip == ShipV4.CARRYING_CAPACITY) {
                emptyBerth.await();
            }
            numberOfBerthContainers -= number;
            System.out.println(number + " - SENT CONTAINERS. TOTAL: " + numberOfBerthContainers);
        } finally {
            lock.unlock();
        }

    }

    public int getNumberOfBerth() {
        return numberOfBerth;
    }

    public int getBerthCapacity() {
        return berthCapacity;
    }

    public int countAmountToUnload(int containersOnShip) {
            return containersOnShip;
    }

    public int containersToLoad(int containersOnShip) {
        if ((ShipV4.CARRYING_CAPACITY - containersOnShip) > 0) {
            return ShipV4.CARRYING_CAPACITY - containersOnShip;
        }
        return 0;
    }
}
