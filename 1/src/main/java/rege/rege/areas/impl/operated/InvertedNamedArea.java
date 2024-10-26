package rege.rege.areas.impl.operated;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.util.NamedArea;

public class InvertedNamedArea<T> extends InvertedArea<Map.Entry<String, T>>
implements NamedArea<T> {
    @Contract(pure = true)
    public InvertedNamedArea(@NotNull NamedArea<T> original) {
        super(original);
    }

    public boolean containsNamed(String name, T point) {
        return !((NamedArea<T>)this.original).containsNamed(name, point);
    }
}
