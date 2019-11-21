package Module.Stmt;

import Module.Expression.Exp;
import Module.MyException;
import Module.PrgState;
import Module.Type.BoolType;
import Module.Value.BoolValue;
import Module.Value.Value;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {
        exp = e;
        thenS = t;
        elseS = el;
    }

    public String toString() {
        return "IF (" + exp.toString() + ") THEN(" + thenS.toString() + ") ELSE(" + elseS.toString() + ")";
    }

    public PrgState execute(PrgState state) throws MyException
    {
        Value v = exp.eval(state.getSymTable());
        if (v.getType().equals(new BoolType()))
        {
            if (v.equals(new BoolValue(true)))
                thenS.execute(state);
            else if (elseS != null)
                elseS.execute(state);
            else
                throw new MyException("Invalid conditions!");
        }
        else
            throw new MyException("Invalid expression type!");
        return state;
    }

    public Exp getExp() {
        return exp;
    }

    public IStmt getElseS() {
        return elseS;
    }

    public IStmt getThenS() {
        return thenS;
    }
}
