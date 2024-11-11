package Lab_6;

public class MyList<T> implements MyListI<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    private static class Node<T>{
        T data;
        public Node<T> next;
        public Node<T> prev;
        Node(T data){
            this.data = data;
        }
    }

    MyList(){
        this.size = 0;
    }



    @Override
    public void add(T val) {
        this.size+=1;
        if(this.head == null){
            head = new Node<T>(val);
            tail = head;
            return;
        }
        Node<T> next = new Node<T>(val);

        next.prev = tail;
        next.prev.next = next;

        tail = next;
    }

    @Override
    public T getElement(int index) {

        Node<T> current;
        int currentIndex;
        if(index > size/2){
            current = tail;
            currentIndex = size-1;
            while(currentIndex>index){
                current = current.prev;
                currentIndex-=1;
            }
        }
        else{
            current = head;
            currentIndex = 0;
            while (currentIndex<index){
                current=current.next;
                currentIndex+=1;
            }
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIteratorI<T> iterator() {
        MyIterator<T> iterator = new MyIterator<T>();
        iterator.current=head;
        return iterator;
    }

    private static class MyIterator<T> implements MyIteratorI<T>{
        public Node<T> current;

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public T next() {
            T temp = current.data;
            current = current.next;
            return temp;
        }
    }
}
