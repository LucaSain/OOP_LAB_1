package Lab_9;


import java.util.Random;

public class Producer implements Runnable {
    private final Kitchen kitchen;

    private Pizza bake(){
        int id = 0;
        Random rnd = new Random();
        return new Pizza(rnd.nextInt(3,7));
    }

    Producer (Kitchen kitchen){
        this.kitchen = kitchen;
    }

    @Override
    public void run() {

        Pizza pizza = bake();
        kitchen.addPizza(pizza);
        System.out.println("Pizza " + pizza.id() + " was added");
        try {
            Thread.sleep(5 + pizza.noIngredients() * 200L);
        } catch (InterruptedException _) {
        }
    }
}
