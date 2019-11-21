package Module.Expression;
import Module.MyException;
import Module.ADTs.MyIDictionary;
import Module.Type.IntType;
import Module.Value.IntValue;
import Module.Value.Value;

public class ArithExp implements Exp {
    private Exp e1;
    private Exp e2;
    private int op; //1: plus | 2: minus | 3: multiply | 4: divide

    public ArithExp(Exp e1, Exp e2, int op)
    {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1= ((IntValue) v1).getVal();
                n2 = ((IntValue) v2).getVal();
                if (op==1)
                    return new IntValue(n1+n2);
                if (op ==2)
                    return new IntValue(n1-n2);
                if(op==3)
                    return new IntValue(n1*n2);
                if(op==4)
                    if(n2==0)
                        throw new MyException("Division by zero!");
                    else
                        return new IntValue(n1/n2);
                else throw new MyException("Wrong operator!");
                }
            else
                throw new MyException("Second operand is not an integer!");
        }
        else
            throw new MyException("First operand is not an integer!");
    }

    public Exp getE1() {
        return e1;
    }

    public Exp getE2() {
        return e2;
    }

    public int getOp() {
        return op;
    }

    @Override
    public String toString() {
        String tprt;
        if (op==1)
            tprt = "+";
        else if (op ==2)
            tprt = "-";
        else if(op==3)
            tprt = "*";
        else if(op==4)
            tprt = "/";
        else
            tprt = "NOT OK";
        return e1.toString() + " " + tprt + " " + e2.toString();
    }
}
