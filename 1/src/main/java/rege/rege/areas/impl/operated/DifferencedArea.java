package rege.rege.areas.impl.operated;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class DifferencedArea<T> implements Area<T> {
    @NotNull
    public final Area<T> left;
    @NotNull
    public final Area<T> right;

    @Contract(pure = true)
    public DifferencedArea(@NotNull Area<T> left, @NotNull Area<T> right) {
        this.left = left;
        this.right = right;
    }

    public boolean contains(T point) {
        return this.left.contains(point) && !this.right.contains(point);
    }
}
