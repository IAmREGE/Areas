package rege.rege.areas.impl.operated;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;

public class Stack10NamedArea<T> extends Stack10Area<Map.Entry<String, T>>
implements NamedArea<T> {
    public Stack10NamedArea(@NotNull NamedArea<T>... original) {
        super(original);
    }

    public boolean containsNamed(String name, T point) {
        boolean res = false;
        for (Area<Map.Entry<String, T>> i : this.getOriginal()) {
            if (((NamedArea<T>)i).containsNamed(name, point)) {
                res = !res;
            }
        }
        return res;
    }
}
