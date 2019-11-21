package Module.ADTs;
import Module.Value.Value;

import java.util.*;

public interface MyIDictionary<Key, Value> {
    void add(Key k, Value v);
    void remove(Key k, Value v);
    boolean isEmpty();

    Value lookup(Key id);

    Value getValue(Key id);

    boolean IsDefined(Key id);

    void update(Key id, Value val);
}
