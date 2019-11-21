package Module.Type;

import Module.Value.StringValue;
import Module.Value.Value;

public class StringType implements Type {

    public boolean equals(Object another){
        return another instanceof StringType;
    }

    @Override
    public Value defaultValue() {
        return new StringValue("");
    }

    public String toString() {
        return "string";
    }
}
