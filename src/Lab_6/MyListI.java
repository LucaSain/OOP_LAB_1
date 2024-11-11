package Lab_6;

public interface MyListI<T> {
    void add(T val);
    T getElement(int index);
    int size();
    MyIteratorI<T> iterator();
}
