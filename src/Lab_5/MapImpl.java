package Lab_5;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MapImpl<K,V> implements Map<K,V>{
    LinkedList<K> keys;
    LinkedList<V> values;
    @Override
    public void add(K key, V val) {
        keys.add(key);
        values.add(val);
    }

    @Override
    public void remove(K key) {
        final int index = keys.indexOf(key);
        values.remove(index);
        keys.remove(index);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public Collection<K> keys() {
        return keys;
    }

    @Override
    public void print() {
        for(K key:keys){
            final int index= keys.indexOf(key);
            System.out.println(key+" : "+values.get(index));
        }
    }
}
