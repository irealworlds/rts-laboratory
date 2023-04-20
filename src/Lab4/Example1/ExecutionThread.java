package Lab4.Example1;

public class ExecutionThread extends Thread {
    private final Object monitor;
    private final int sleepMin;
    private final int sleepMax;
    private final int activityMin;
    private final int activityMax;

    public ExecutionThread(Object monitor, int sleepMin, int sleepMax, int activityMin, int activityMax) {
        this.monitor = monitor;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
    }

    @Override
    public void run() {
        System.out.println("State 1");

        try {
            Thread.sleep(Math.round(Math.random() * (this.sleepMax - this.sleepMin) + this.sleepMin) * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("State 2");

        synchronized (this.monitor) {
            System.out.println("State 3");

            var k = (int) Math.round(Math.random() * (this.activityMax - this.activityMin) + this.activityMin);
            for (int i = 0; i < k * 100000; i++) {
                ++i;
                --i;
            }
        }

        System.out.println("State 4");
    }
}
