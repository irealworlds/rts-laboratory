package Lab4.Application3;

import Lab4.BaseExerciseThread;

public class ExecutionThread extends BaseExerciseThread {
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
        while(true) {
            this.printMessage("State 1");

            synchronized (this.monitor) {
                this.printMessage("State 2");

                this.activity(this.activityMin, this.activityMax);
            }

            this.printMessage("State 3");

            this.sleep(this.sleepMin, this.sleepMax);

            this.printMessage("State 4");
        }
    }
}
