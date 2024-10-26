package rege.rege.areas.util;

import java.util.Arrays;
import java.util.Map;

import org.jetbrains.annotations.Contract;

public class NamedPoint<T> implements Map.Entry<String, T> {
    public final String name;
    public final T point;

    public NamedPoint(String name, T point) {
        this.name = name;
        this.point = point;
    }

    public String getKey() {
        return this.name;
    }

    public T getValue() {
        return this.point;
    }

    @Contract("_ -> fail")
    public T setValue(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NamedPoint)) {
            return false;
        }
        NamedPoint<?> that = (NamedPoint<?>)o;
        return (this.name == null ? that.name == null :
                this.name.equals(that.name)) &&
               (this.point == null ? that.point == null :
                this.point.equals(that.point));
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.point});
    }
}
