package Lab_9;

public class Timer {
    // Implementation using Thread class
    static class TimePrinterThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Current time: " + java.time.LocalTime.now());
                    Thread.sleep(10000); // 10 seconds
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + this.getName());
            }
        }
    }

    static class TimePrinterRunnable implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Current time: " + java.time.LocalTime.now());
                    Thread.sleep(10000); // 10 seconds
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + Thread.currentThread().getName());
            }
        }
    }

    public void runThread(){
        for(int i=0;i<3;i++){
            Thread th = new Thread(new TimePrinterThread());
            th.start();
        }
    }

    public void runRunnable(){
        for(int i=0;i<3;i++){
            Thread th = new Thread(new TimePrinterRunnable());
            th.start();
        }
    }
}
