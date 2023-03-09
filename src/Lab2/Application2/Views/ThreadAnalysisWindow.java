package Lab2.Application2.Views;

import javax.swing.*;
import java.util.ArrayList;

public class ThreadAnalysisWindow extends JFrame {
    ArrayList<ThreadProgressTracker> threads = new ArrayList<ThreadProgressTracker>();

    public ThreadAnalysisWindow() {
        setLayout(null);
        setSize(450,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addThread(ThreadProgressTracker thread) {
        thread.addToFrame(this);
        threads.add(thread);
    }

    public void setThreadProgress(int id, double progress) {
        threads.get(id).setProgress(progress);
    }
}
