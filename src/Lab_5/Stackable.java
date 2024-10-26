package Lab_5;

public interface Stackable<T> {
    void push(T el);
    T pop();
    void print();
    boolean isEmpty();
}
