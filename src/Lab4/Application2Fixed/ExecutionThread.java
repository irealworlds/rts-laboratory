package Lab4.Application2Fixed;

import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread {

    Integer[] monitor;
    int[] activity1, activity2;
    int sleep;
    ReentrantLock lock1, lock2;

    public ExecutionThread(Integer[] monitor, int sleep, int[] activity1, int[] activity2, ReentrantLock lock1, ReentrantLock lock2) {

        this.monitor = monitor;
        this.sleep = sleep;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.lock1 = lock1;
        this.lock2 = lock2;

    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[1]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " - TRANSITION 1 - 2");
        if (this.lock1.tryLock()) {
            try {
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[1]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                System.out.println(this.getName() + " - TRANSITION 2 - 3");
                boolean locked = lock2.tryLock();
                if (locked) {
                    try {
                        System.out.println(this.getName() + " - STATE 3");

                        try {
                            Thread.sleep(sleep);
                        } catch (Exception e) {

                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            } finally {
                lock1.unlock();
            }
            System.out.println(this.getName() + " - TRANSITION 3 - 4");

            System.out.println(this.getName() + " - STATE 4");
        }
    }

}
