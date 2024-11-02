package rege.rege.areas.impl.operated;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;

public class NamelessFromOneNameArea<T> implements Area<T> {
    @NotNull
    public final NamedArea<T> original;
    public final String name;

    public
    NamelessFromOneNameArea(@NotNull NamedArea<T> original, String name) {
        this.original = original;
        this.name = name;
    }

    public boolean contains(T point) {
        return this.original.containsNamed(this.name, point);
    }
}
