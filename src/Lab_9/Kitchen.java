package Lab_9;

public class Kitchen {
    private boolean hasPizza=false;
    private Pizza pizza;


    public synchronized boolean hasPizza(){
        return hasPizza;
    }

    public synchronized void addPizza(Pizza pizza) {
        while(hasPizza){
            try{
                wait();
            }catch (InterruptedException _){
            }
        }
        hasPizza=true; //Set guard
        System.out.println(Thread.currentThread().getName()+ " baked a pizza!");
        this.pizza = pizza;
        notifyAll(); //Release guard
    }

    public synchronized void yoinkPizza(){
        while(!hasPizza){
            try {
                wait();
            }catch (InterruptedException _){

            }
        }
        hasPizza=false; //Set guard
        System.out.println(Thread.currentThread().getName()+ " stole the pizza.");
        notifyAll(); //Release guard
    }
}
