package rege.rege.areas.impl.operated;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class IntersectedArea<T> implements Area<T> {
    @NotNull
    private final Area<T>[] original;

    public IntersectedArea(@NotNull Area<T>... original)
    throws NullPointerException {
        for (int i = 0; i < original.length; i++) {
            if (original[i] == null) {
                throw new NullPointerException("index " + i + " is null");
            }
        }
        this.original = original;
    }

    public boolean contains(T point) {
        for (Area<T> i : this.original) {
            if (!i.contains(point)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    Area<T>[] getOriginal() {
        if (this.getClass() != IntersectedNamedArea.class) {
            throw new RuntimeException("invoke getOriginal in another class");
        }
        return this.original;
    }
}
