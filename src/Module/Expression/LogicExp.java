package Module.Expression;
import Module.ADTs.MyIDictionary;
import Module.Type.BoolType;
import Module.Value.BoolValue;
import Module.Value.Value;
import Module.MyException;

public class LogicExp implements Exp {
    private Exp  e1;
    private Exp e2;
    private int op; // 1 - && | 2 - ||

    LogicExp(Exp e1, Exp e2, int op)
    {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException{
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new BoolType()))
        {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new BoolType()))
            {
                BoolValue b1 = (BoolValue)v1;
                BoolValue b2 = (BoolValue)v2;
                boolean n1, n2;
                n1 = ((BoolValue) v1).getVal();
                n2 = ((BoolValue) v2).getVal();
                if (op == 1)
                {
                    boolean b = n1 && n2;
                    return new BoolValue(b);
                }
                else if (op == 2)
                {
                    boolean b = n1 || n2;
                    return new BoolValue(b);
                }
                else throw new MyException("Wrong operator!");
            }
            else
                throw new MyException("Second operand is not a boolean!");
        }
        else
            throw new MyException("First operand is not a boolean!");
    }

    public int getOp() {
        return op;
    }

    public Exp getE1() {
        return e1;
    }

    public Exp getE2() {
        return e2;
    }

    @Override
    public String toString() {
        String p;
        if (op == 1)
            p = "&&";
        else if (op == 2)
            p = "||";
        else
            p = "NOT OK";
        return e1.toString() + " " + p + " " + e2.toString();
    }
}
