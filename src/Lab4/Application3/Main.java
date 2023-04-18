package Lab4.Application3;

public class Main {
    public static void main(String[] args) {
        var monitor = Integer.valueOf(1);

        var thread1 = new ExecutionThread(monitor, 5, 5, 3, 6);
        var thread2 = new ExecutionThread(monitor, 3, 3, 4, 7);
        var thread3 = new ExecutionThread(monitor, 6, 6, 5, 7);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
