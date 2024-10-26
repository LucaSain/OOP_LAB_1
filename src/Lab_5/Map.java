package Lab_5;

import java.util.Collection;

public interface Map<K,V>{
    void add(K key,V val);
    void remove(K key);
    int size();
    boolean isEmpty();
    Collection<K> keys();
    void print();
}
