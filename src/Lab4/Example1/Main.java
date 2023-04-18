package Lab4.Example1;

public class Main {
    public static void main(String[] args) {
        var monitor1 = Integer.valueOf(1);

        var thread1 = new ExecutionThread(monitor1, 3, 5, 4, 7);
        var thread2 = new ExecutionThread(monitor1, 2, 4, 3, 6);

        thread1.start();
        thread2.start();
    }
}
