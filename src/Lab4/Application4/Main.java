package Lab4.Application4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var monitor1 = Integer.valueOf(1);
        var monitor2 = Integer.valueOf(1);

        var thread1 = new ExecutionThread(new Object[] {monitor1, monitor2}, null, 7, 7, 2, 3);
        var thread2 = new ExecutionThread(null, monitor2, 0, 0, 3, 5);
        var thread3 = new ExecutionThread(null, monitor1, 0, 0, 4, 6);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
