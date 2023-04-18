package Lab3.Application1;

public class WThread extends Thread{

    public final FileService service;

    public WThread(FileService service) {

        this.service = service;

    }

    public void run(){
        synchronized (service) {
            while(!



                    Main.isStopThreads()){
                String msg = String.valueOf(Math.round(Math.random()*100));
                service.write(msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}