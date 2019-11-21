package Module.Type;

import Module.Value.Value;

public interface Type {
    boolean equals(Object another);
    Value defaultValue();
}
