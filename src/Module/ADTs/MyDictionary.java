package Module.ADTs;

import java.util.*;

public class MyDictionary<Key, Value> implements MyIDictionary<Key, Value> {
    private Map<Key, Value> dictionary;

    public MyDictionary()
    {
        dictionary = new HashMap<Key, Value>();
    }

    @Override
    public void add(Key k, Value v) {
        dictionary.put(k, v);
    }

    @Override
    public void remove(Key k, Value v) {
        dictionary.remove(k, v);
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    @Override
    public Value lookup(Key id) {
        return dictionary.get(id);
    }

    @Override
    public Value getValue(Key id) {
        return dictionary.get(id);
    }

    @Override
    public boolean IsDefined(Key id) {
        return dictionary.containsKey(id);
    }

    @Override
    public void update(Key id, Value val) {
        dictionary.put(id, val);
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Dictionary:\n");
        Set<Key> keys = dictionary.keySet();
        Collection<Value> val = dictionary.values();
        Object[] a1 = keys.toArray();
        Object[] a2 = val.toArray();
        int idx;
        for (idx = 0; idx < dictionary.size(); idx++) {
            toPrint.append(a1[idx]).append(" = ").append(a2[idx]).append("\n");
        }
        return String.valueOf(toPrint);
    }
}
