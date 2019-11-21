package Module.ADTs;
import java.util.*;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stk;

    public MyStack()
    {
        stk = new Stack<T>();
    }

    @Override
    public T pop() {
        return stk.pop();
    }

    @Override
    public void push(T v) {
        stk.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stk.empty();
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Stack:\n");
        for (T s : stk)
            toPrint.append(s.toString()).append("\n");
        return String.valueOf(toPrint);
    }
}
