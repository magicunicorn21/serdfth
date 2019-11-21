package Module.Expression;
import Module.ADTs.MyIDictionary;
import Module.Value.Value;
import Module.MyException;

public interface Exp {
    Value eval(MyIDictionary<String, Value> tbl) throws MyException;
}
