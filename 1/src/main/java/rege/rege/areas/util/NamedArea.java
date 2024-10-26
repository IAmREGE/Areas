package rege.rege.areas.util;

import java.util.Map;

import rege.rege.areas.base.Area;

public interface NamedArea<T> extends Area<Map.Entry<String, T>> {
    boolean containsNamed(String name, T point);
}
