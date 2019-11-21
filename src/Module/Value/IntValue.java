package Module.Value;
import Module.Type.IntType;
import Module.Type.Type;

public class IntValue implements Value {
    private int val;

    public IntValue(int v) {
        val = v;
    }

    public int getVal() {
        return val;
    }

    public String toString() {
        return "int " + val;
    }

    public Type getType() {
        return new IntType();
    }

    public boolean equals(Object another) {
        return another instanceof IntValue;
    }
}
