package Module.Stmt;

import Module.ADTs.MyIDictionary;
import Module.ADTs.MyIList;
import Module.ADTs.MyIStack;
import Module.Expression.Exp;
import Module.PrgState;
import Module.MyException;
import Module.Value.Value;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp exp)
    {
        this.exp = exp;
    }

    public String toString() {
        return "print(" + exp.toString() + ")";
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack stk = state.getStk();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIList<Value> out = state.getOut();
        Value v = exp.eval(symTable);
        out.add(v);
        return state;
    }

    public Exp getExp() {
        return exp;
    }
}
