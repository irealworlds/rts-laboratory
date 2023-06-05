package Lab8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var pMove = new P_move(0);
        var pArrived = new P_arrived(0);

        pMove.move = 0;

        var plant = new Plant();
        var userDemand = new P_user(0);
        var userDisplay = new Ps_user(0);
        var controller = new Controller();
        var supervisor = new Supervisor(userDisplay);
        MessagePrinter printer = new MessagePrinter();

        plant.init(pMove, pArrived);
        controller.init(userDemand, userDisplay, pMove, pArrived);
        printer.display = userDisplay;

        plant.start();
        controller.start();
        supervisor.start();
        printer.start();

        // listen for requests
        var in = new Scanner(System.in);
        System.out.print("Places to go: ");
        while (true) {
            userDemand.x = in.nextInt();
            userDemand.release();
        }
    }
}

class MessagePrinter extends Thread { // this is the user display listener
    Ps_user display;

    public void run() {
        while (true) {
            try {
                display.acquire();
                System.out.println("Arrived at: " + display.x);
            } catch (Exception ignored) {
            }
        }
    }
}