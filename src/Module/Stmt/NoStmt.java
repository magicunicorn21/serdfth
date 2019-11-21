package Module.Stmt;
import Module.MyException;
import Module.PrgState;

public class NoStmt implements IStmt {

    public NoStmt() {};

    @Override
    public PrgState execute(PrgState state) throws MyException
    {
        return state;
    }

    @Override
    public String toString() {
        return "No operation";
    }
}
