package Module.ADTs;
import java.util.*;

public class MyList<T> implements MyIList<T> {
    private ArrayList<T> lst;

    public MyList()
    {
        lst = new ArrayList<T>();
    }

    @Override
    public void add(T v) {
        lst.add(v);
    }

    @Override
    public void remove(T v) {
        lst.remove(v);
    }

    @Override
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("List:\n");
        int i;
        for (i = 0; i < lst.size(); i += 1)
            toPrint.append(lst.get(i).toString()).append("\n");
        return String.valueOf(toPrint);
    }
}
