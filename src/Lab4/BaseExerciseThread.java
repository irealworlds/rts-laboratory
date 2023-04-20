package Lab4;

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
        System.out.println(this.getName() + " - " + message);
    }
}
