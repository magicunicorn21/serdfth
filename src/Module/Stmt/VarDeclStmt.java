package Module.Stmt;

import Module.ADTs.MyIDictionary;
import Module.Type.BoolType;
import Module.Type.Type;
import Module.MyException;
import Module.PrgState;
import Module.Value.BoolValue;
import Module.Value.IntValue;
import Module.Value.Value;

public class VarDeclStmt implements IStmt {
    private String name;
    private Type typ;

    public VarDeclStmt(String name, Type type)
    {
        this.name = name;
        this.typ = type;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> st = state.getSymTable();
        if (typ instanceof BoolType)
            st.add(name, typ.defaultValue());
        else
            st.add(name, typ.defaultValue());
        return state;
    }

    public String getName() {
        return name;
    }

    public Type getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return typ.toString() + " " + name;
    }
}
