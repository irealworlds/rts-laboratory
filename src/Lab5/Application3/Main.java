package Lab5.Application3;

public class Main {
    public static void main(String[] args) {
        NumberBuffer numberBuffer = new NumberBuffer();
        Producer producer = new Producer(numberBuffer);
        Consumer consumer1 = new Consumer(numberBuffer, false);
        Consumer consumer2 = new Consumer(numberBuffer, false);
        Consumer consumer3 = new Consumer(numberBuffer, false);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        Thread consumerThread3 = new Thread(consumer3);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }
}