package controller;
import Module.ADTs.MyIStack;
import Module.MyException;
import Module.PrgState;
import Module.Stmt.IStmt;
import repository.MyRepository;

public class Controller
{

    private MyRepository repo;

    public Controller(MyRepository repo)
    {
        this.repo = repo;
    }

    public MyRepository getRepo() {
        return repo;
    }

    public void oneStep(PrgState state) throws MyException {
        {
            MyIStack<IStmt> stk = state.getStk();
            repo.logPrgStateExec();
            //System.out.println(prg.toString());
            if (stk.isEmpty())
                throw new MyException("PrgState stack is empty");
            IStmt crtStmt = stk.pop();
            crtStmt.execute(state);
            repo.logPrgStateExec();
            System.out.println(state.toString());
        }
    }

    public void allStep() throws MyException
    {
        PrgState prg = repo.getState();
        repo.logPrgStateExec();
        //System.out.println(prg.toString());
        while (!prg.getStk().isEmpty())
        {
            try {
                this.oneStep(prg);
            } catch (MyException myException) {
                myException.printStackTrace();
            }
            System.out.println(prg.toString());
            repo.logPrgStateExec();
        }
    }
}
