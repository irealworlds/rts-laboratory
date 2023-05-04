package Lab4.Application2Fixed;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Integer[] monitors = {1, 2};
        int[] activity1 = {1, 3};
        int[] activity2 = {2, 4};
        int sleep = 100;

        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        ExecutionThread thread1 = new ExecutionThread(monitors, sleep, activity1, activity2, lock1, lock2);
        ExecutionThread thread2 = new ExecutionThread(monitors, sleep, activity1, activity2, lock2, lock1);

        thread1.start();
        thread2.start();

    }

}