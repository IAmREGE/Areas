package rege.rege.areas.impl.operated;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;

public class IntersectedNamedArea<T>
extends IntersectedArea<Map.Entry<String, T>> implements NamedArea<T> {
    public IntersectedNamedArea(@NotNull NamedArea<T>... original) {
        super(original);
    }

    public boolean containsNamed(String name, T point) {
        for (Area<Map.Entry<String, T>> i : this.getOriginal()) {
            if (!((NamedArea<T>)i).containsNamed(name, point)) {
                return false;
            }
        }
        return true;
    }
}
