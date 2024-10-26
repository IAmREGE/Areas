package rege.rege.areas.impl.operated;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class InvertedArea<T> implements Area<T> {
    @NotNull
    public final Area<T> original;

    @Contract(pure = true)
    public InvertedArea(@NotNull Area<T> original) {
        this.original = original;
    }

    public boolean contains(T point) {
        return !this.original.contains(point);
    }
}
