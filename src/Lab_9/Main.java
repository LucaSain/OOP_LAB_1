package Lab_9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(numThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        ArrayList<String> fileList = new ArrayList<String>( List.of("1.txt","2.txt","3.txt","4.txt","5.txt","6.txt","7.txt"));
        //Timer tr = new Timer();
        //tr.runThread();
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.deposit(1000);
//        Thread tr1 = new Thread(()->bankAccount.deposit(100));
//        Thread tr2 = new Thread(()->bankAccount.withDraw(50));
//        tr1.start();
//        //tr1.join(); //bullshit =)))))
//        tr2.start();
//        bankAccount.deposit(0);

//        Kitchen kitchen = new Kitchen();
//        Thread tr1 = new Thread(new Producer(kitchen));
//        Thread tr2 = new Thread(new Consumer(kitchen));
//        tr1.start();
//        tr2.start();

        MapReduceDEI mrd = new MapReduceDEI();
        mrd.compute(fileList,0, fileList.size()-1);
        mrd.display();
    }
}
