package Lab4.Application1;

public class Main {
    public static void main(String[] args) {
        var monitor1 = Integer.valueOf(1);
        var monitor2 = Integer.valueOf(2);

        var thread1 = new ExecutionThread(monitor1, null, 4, 4, 2, 4);
        var thread2 = new ExecutionThread(monitor1, monitor2, 3, 3, 3, 6);
        var thread3 = new ExecutionThread(monitor2, null, 5, 5, 2, 5);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
