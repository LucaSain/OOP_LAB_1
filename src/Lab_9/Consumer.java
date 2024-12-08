package Lab_9;

public class Consumer implements Runnable {
    Kitchen kitchen;

    Consumer(Kitchen kitchen){
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        kitchen.yoinkPizza();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException _) {
            System.out.println("No more pizza:(");
        }
    }
}
