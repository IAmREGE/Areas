package rege.rege.areas.impl.operated;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.util.NamedArea;

public class DifferencedNamedArea<T>
extends DifferencedArea<Map.Entry<String, T>> implements NamedArea<T> {
    @Contract(pure = true)
    public DifferencedNamedArea(@NotNull NamedArea<T> left,
                                @NotNull NamedArea<T> right) {
        super(left, right);
    }

    public boolean containsNamed(String name, T point) {
        return ((NamedArea<T>)this.left).containsNamed(name, point) &&
               !((NamedArea<T>)this.right).containsNamed(name, point);
    }
}
