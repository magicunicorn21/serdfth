package repository;
import Module.ADTs.MyList;
import Module.PrgState;
import Module.MyException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements MyRepository {
    private List<PrgState> states;
    private String logFilePath;

    public Repository(String lfp)
    {
        this.states = new ArrayList<PrgState>();
        this.logFilePath = lfp;
    }

    public void addPrgState(PrgState ps)
    {
        this.states.add(ps);
    }

    @Override
    public PrgState getState() {
        return states.get(0);
    }

    @Override
    public void logPrgStateExec() throws MyException {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
            logFile.println(states.get(0).toString());
            logFile.close();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        };
    }
}
