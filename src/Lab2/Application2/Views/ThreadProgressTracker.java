package Lab2.Application2.Views;

import javax.swing.*;

public class ThreadProgressTracker {
    private final JProgressBar progressBar;
    private final JLabel label;
    public int id;

    public ThreadProgressTracker(int id, double offsetY) {
        // Set the ID
        this.id = id;

        progressBar = new JProgressBar();
        progressBar.setMaximum(1000);
        progressBar.setBounds(50, (int)offsetY + 30,350,20);

        label = new JLabel();
        label.setText("Thread " + id);
        label.setBounds(50, (int)offsetY + 30, 100, 20);
    }

    public void addToFrame(JFrame frame) {
        frame.add(progressBar);
        frame.add(label);
    }

    public void setProgress(double progress) {
        progressBar.setValue((int)progress);
    }
}
