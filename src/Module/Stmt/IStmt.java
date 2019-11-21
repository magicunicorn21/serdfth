package Module.Stmt;
import Module.PrgState;
import Module.MyException;

public interface IStmt {
    public PrgState execute(PrgState state) throws MyException;
    public String toString();
}
