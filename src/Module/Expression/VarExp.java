package Module.Expression;
import Module.ADTs.MyIDictionary;
import Module.Value.Value;
import Module.MyException;

public class VarExp implements Exp {
    private String id;

    public VarExp(String id) { this.id = id; }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException  {
        return tbl.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }
}
