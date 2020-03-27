package task8.v2;

import java.util.concurrent.Semaphore;

public class MainV2 {
    public static final Semaphore SEMAPHORE = new Semaphore(1, true);

    public static void main (String [] args) {
        PortV2 portV2 = new PortV2();
    }
}
