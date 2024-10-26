package rege.rege.areas.impl.operated;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class Stack10Area<T> implements Area<T> {
    @NotNull
    private final Area<T>[] original;

    public Stack10Area(@NotNull Area<T>... original)
    throws NullPointerException {
        for (int i = 0; i < original.length; i++) {
            if (original[i] == null) {
                throw new NullPointerException("index " + i + " is null");
            }
        }
        this.original = original;
    }

    public boolean contains(T point) {
        boolean res = false;
        for (Area<T> i : this.original) {
            if (i.contains(point)) {
                res = !res;
            }
        }
        return res;
    }

    @NotNull
    Area<T>[] getOriginal() {
        if (this.getClass() != Stack10NamedArea.class) {
            throw new RuntimeException("invoke getOriginal in another class");
        }
        return this.original;
    }
}
