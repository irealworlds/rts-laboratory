package Lab4.Application2;

import Lab4.BaseExerciseThread;

public class ExecutionThread extends BaseExerciseThread {
    private final Object monitor1;
    private final Object monitor2;
    private final int sleepMin;
    private final int sleepMax;
    private final int activity1Min;
    private final int activity1Max;
    private final int activityMin;
    private final int activityMax;

    public ExecutionThread(Object monitor1, Object monitor2, int sleepMin, int sleepMax, int activity1Min, int activity1Max, int activityMin, int activityMax) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.activity1Min = activity1Min;
        this.activity1Max = activity1Max;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
    }

    @Override
    public void run() {
        this.printMessage("State 1");

        this.activity(this.activity1Min, this.activity1Max);

        synchronized (this.monitor1) {
            synchronized (this.monitor2) {
                this.printMessage("State 2");

                this.activity(this.activityMin, this.activityMax);
            }

            this.printMessage("State 3");
        }

        this.sleep(this.sleepMin, this.sleepMax);

        this.printMessage("State 4");
    }
}
