package Lab2.Application2.Controllers;

import Lab2.Application2.Models.Fir;
import Lab2.Application2.Models.ThreadUpdateNotification;
import Lab2.Application2.Views.ThreadAnalysisWindow;
import Lab2.Application2.Views.ThreadProgressTracker;

import java.util.Observable;
import java.util.Observer;

public class ThreadAnalysisController implements Observer {
    private ThreadAnalysisWindow window;

    public void Start(int threadNumber, int processorLoad) {
        window = new ThreadAnalysisWindow();

        for (int i = 0; i < threadNumber; i++) {
            var thread = new ThreadProgressTracker(i, 30 * i);
            window.addThread(thread);
        }

        for (int i = 0; i < threadNumber; i++) {
            var fir = new Fir(i, processorLoad);
            fir.addObserver(this);

            var firThread = new Thread(fir);
            if (i + 2 > Thread.MAX_PRIORITY) {
                System.out.println("Thread " + i + " has a priority of " + (i + 2) + " which is higher than the maximum priority of " + Thread.MAX_PRIORITY);
            } else {
                firThread.setPriority(i + 2);
                firThread.start();
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // Make sure the arg is of type ThreadUpdateNotification
        if (!(arg instanceof ThreadUpdateNotification notification)) {
            return;
        }

        window.setThreadProgress(notification.id, notification.progress);
    }
}
