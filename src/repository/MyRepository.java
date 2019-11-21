package repository;
import Module.PrgState;
import Module.MyException;

public interface MyRepository {
    public PrgState getState();
    public void logPrgStateExec() throws MyException;
}
