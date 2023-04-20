package Lab4.Application1;

import Lab4.BaseExerciseThread;

public class ExecutionThread extends BaseExerciseThread {
    private final Object monitor1;
    private final Object monitor2;
    private final int sleepMin;
    private final int sleepMax;
    private final int activityMin;
    private final int activityMax;

    public ExecutionThread(Object monitor1, Object monitor2, int sleepMin, int sleepMax, int activityMin, int activityMax) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
    }

    @Override
    public void run() {
        this.printMessage("State 1");

        if (this.monitor2 != null) {
            synchronized (this.monitor1) {
                synchronized (this.monitor2) {
                    this.printMessage("State 2");

                    this.activity(this.activityMin, this.activityMax);

                    this.sleep(this.sleepMin, this.sleepMax);
                }
            }
        } else {
            synchronized (this.monitor1) {
                this.printMessage("State 2");

                this.activity(this.activityMin, this.activityMax);

                this.sleep(this.sleepMin, this.sleepMax);
            }
        }

        this.printMessage("State 3");
    }
}
