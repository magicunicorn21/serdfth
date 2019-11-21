package Module.Expression;
import Module.ADTs.MyIDictionary;
import Module.Value.Value;
import Module.MyException;

public class ValueExp implements Exp {
    private Value e;

    public ValueExp(Value e)
    {
        this.e = e;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException{
        return e;
    }

    public Value getE() {
        return e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
