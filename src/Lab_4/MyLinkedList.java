package Lab_4;



import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;

    public void add(T val) {
        if(first == null || first.value==null){
            first = new Node<>(val);
            return;
        }

        Node<T> current = first;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node<>(val);
    }

    public T get(int index) {
        Node<T> current = first;
        while(index>0 && current.next !=null){
            index--;
            current = current.next;
        }
        if(index>0){
            throw new IndexOutOfBoundsException();
        }
        return current.value;
    }

    public T remove() {
        Node<T>current = first;
        if(first==null){
            throw new NoSuchElementException();
        }
        while(current.next.next!=null){
            current=current.next;
        }
        T val = current.next.value;
        current.next=null;
        return val;
    }



    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
