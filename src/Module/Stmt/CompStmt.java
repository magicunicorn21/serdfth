package Module.Stmt;
import Module.ADTs.MyIStack;
import Module.MyException;
import Module.PrgState;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt first, IStmt second)
    {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first.toString() + "; " + second.toString() + ")";
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        stk.push(second);
        stk.push(first);
        return state;
    }

    public IStmt getFirst() {
        return first;
    }

    public IStmt getSecond() {
        return second;
    }
}
