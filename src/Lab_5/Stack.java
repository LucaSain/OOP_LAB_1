package Lab_5;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Stackable<T>{
    private final LinkedList<T> linkedList;

    public Stack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void push(T el){
        linkedList.push(el);
    }

    @Override
    public T pop(){
       return linkedList.pop();
    }

    @Override
    public void print(){
        Iterator<T> it = linkedList.descendingIterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
