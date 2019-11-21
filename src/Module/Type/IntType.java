package Module.Type;

import Module.Value.IntValue;
import Module.Value.Value;

public class IntType implements Type {
    public boolean equals(Object another) {
        return another instanceof IntType;
    }

    @Override
    public Value defaultValue() {
        return new IntValue(0);
    }

    public String toString() {
        return "int";
    }
}
