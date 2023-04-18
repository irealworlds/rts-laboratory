package Lab4.Application4;

import Lab4.BaseExerciseThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExecutionThread extends BaseExerciseThread {
    private final Object[] notifyTo;
    private final Object waitsFor;
    private final int sleepMin;
    private final int sleepMax;
    private final int activityMin;
    private final int activityMax;

    public ExecutionThread(Object[] notifyTo, Object waitsFor, int sleepMin, int sleepMax, int activityMin, int activityMax) {
        this.notifyTo = notifyTo == null ? new Object[] {} : notifyTo;
        this.waitsFor = waitsFor;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
    }

    @Override
    public void run() {
        this.printMessage("State 1");

        if (this.waitsFor != null) {
            synchronized (this.waitsFor) {
                try {
                    this.waitsFor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        this.sleep(this.sleepMin, this.sleepMax);

        this.printMessage("State 2");

        this.activity(this.activityMin, this.activityMax);

        if (this.notifyTo != null) {
            for (int i = 0; i < this.notifyTo.length; i++) {
                synchronized (this.notifyTo[i]) {
                    this.notifyTo[i].notify();
                }
            }
        }

        this.printMessage("State 3");

        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
