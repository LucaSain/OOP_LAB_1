package Lab_9;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MapReduceDEI {
    private volatile HashMap<String, AtomicInteger> map;

    MapReduceDEI(){
        this.map = new HashMap<>();
    }

    void compute(ArrayList<String> list, int l,int r) throws InterruptedException {

        if(l>r){
            return;
        }
        if(l==r){
            aggregateWordCount(list.get(l));
            return;
        }
        Thread trl = new Thread(()-> {
            try {
                compute(list,(l+r)/2+1,r);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread trd = new Thread(()-> {
            try {
                compute(list,l,(l+r)/2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        trl.start();
        trd.start();
        trl.join();
        trd.join();
    }

    void aggregateWordCount(String filename){

        try(
                Scanner sc = new Scanner(new File(filename))
        ){
            while(sc.hasNext()){
                String word = sc.next();
                map.putIfAbsent(word,new AtomicInteger(0));
                map.get(word).incrementAndGet();
            }
        }catch (Exception _){

        }
    }

    public void display(){
        map.forEach(
                (key,value) -> {
                    System.out.println(key+ " :"+ value);
                }
        );
    }
}
