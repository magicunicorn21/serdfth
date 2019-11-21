package Module;
import Module.ADTs.*;
import Module.Stmt.IStmt;
import Module.Value.Value;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private IStmt originalProgram;

/*    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> ot, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        //originalProgram=deepCopy(prg);//recreate the entire original prg
        stk.push(prg);
    }
*/

    public PrgState()
    {
        exeStack = new MyStack<>();
        symTable = new MyDictionary<>();
        out = new MyList<>();
    }

    public MyIStack<IStmt> getStk() {
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    @Override
    public String toString() {
        return exeStack.toString() + symTable.toString() + out.toString();
    }
}
