package Lab4.Application2;

public class Main {
    public static void main(String[] args) {
        var monitor1 = Integer.valueOf(1);
        var monitor2 = Integer.valueOf(2);

        var thread1 = new ExecutionThread(monitor1, monitor2, 4, 4, 2, 4, 4, 6);
        var thread2 = new ExecutionThread(monitor2, monitor1, 5, 5, 3, 5, 5, 7);

        thread1.start();
        thread2.start();
    }
}
