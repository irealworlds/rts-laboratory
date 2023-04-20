package Lab4;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;

public class BaseExerciseThread extends Thread {
    protected void activity(int min, int max) {
        var k = (int) Math.round(Math.random() * (max - min) + min);
        for (int i = 0; i < k * 100000; i++) {
            ++i;
            --i;
        }
    }

    protected void sleep(int min, int max) {
        try {
            Thread.sleep(Math.round(Math.random() * (max - min) + min) * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void printMessage(String message) {
        String timeStamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new java.util.Date());
        System.out.println(MessageFormat.format("[{0}] {1} - {2}", timeStamp, this.getName(), message));
    }
}
