package Module.Type;

import Module.Value.BoolValue;
import Module.Value.Value;

public class BoolType implements Type {

    public boolean equals(Object another) {
        return another instanceof BoolType;
    }

    @Override
    public Value defaultValue() {
        return new BoolValue(false);
    }

    public String toString() {
        return "bool";
    }
}
