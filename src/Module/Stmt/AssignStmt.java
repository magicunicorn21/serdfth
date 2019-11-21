package Module.Stmt;
import Module.PrgState;
import Module.ADTs.MyIDictionary;
import Module.ADTs.MyIStack;
import Module.Expression.Exp;
import Module.Type.Type;
import Module.Value.Value;
import Module.MyException;

public class AssignStmt implements IStmt{
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp exp)
    {
        this.id = id;
        this.exp = exp;
    }

    public String toString() {
        return id + " = " + exp.toString();
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        Value val = exp.eval(symTbl);
        if (symTbl.IsDefined(id)) {
            Type typeId = (symTbl.getValue(id)).getType();
            if ((val.getType()).equals(typeId))
                symTbl.update(id,val);
            else
                throw new MyException("Declared type of variable " + id + " and type of the assigned expression do not match!");
        }
        else
            throw new MyException("Variable " + id + " was not declared!");
        return state;
    }

    public String getId() {
        return id;
    }

    public Exp getExp() {
        return exp;
    }
}
