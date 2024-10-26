package rege.rege.areas.impl;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;

public abstract class ConstantAreas {
    private static final Area<?> EMPTY = new Area<Object>() {
        @Contract(value = "_ -> false", pure = true)
        public boolean contains(Object point) {
            return false;
        }
    };
    private static final Area<?> FULL = new Area<Object>() {
        @Contract(value = "_ -> true", pure = true)
        public boolean contains(Object point) {
            return true;
        }
    };
    private static final Area<?> NAMED_ALL_EMPTY = new NamedArea<Object>() {
        @Contract(value = "_, _ -> false", pure = true)
        public boolean containsNamed(String name, Object point) {
            return false;
        }

        @Contract("_ -> false")
        public boolean contains(Map.Entry<String, Object> point) {
            return this.containsNamed(point.getKey(), point.getValue());
        }
    };
    private static final Area<?> NAMED_ALL_FULL = new NamedArea<Object>() {
        @Contract(value = "_, _ -> true", pure = true)
        public boolean containsNamed(String name, Object point) {
            return true;
        }

        @Contract("_ -> true")
        public boolean contains(Map.Entry<String, Object> point) {
            return this.containsNamed(point.getKey(), point.getValue());
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> Area<T> empty() {
        return (Area<T>)EMPTY;
    }

    @SuppressWarnings("unchecked")
    public static <T> Area<T> full() {
        return (Area<T>)FULL;
    }

    @SuppressWarnings("unchecked")
    public static <T> NamedArea<T> emptyNamedAll() {
        return (NamedArea<T>)NAMED_ALL_EMPTY;
    }

    @SuppressWarnings("unchecked")
    public static <T> NamedArea<T> fullNamedAll() {
        return (NamedArea<T>)NAMED_ALL_FULL;
    }

    public static <T> NamedArea<T> emptyNamedSome(final String... names) {
        return new NamedArea<T>() {
            @Contract(pure = true)
            public boolean containsNamed(String name, T point) {
                for (String i : names) {
                    if ((name == null) ? i == null : name.equals(i)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean contains(Map.Entry<String, T> point) {
                return this.containsNamed(point.getKey(), point.getValue());
            }
        };
    }

    public static <T> NamedArea<T> fullNamedSome(final String... names) {
        return new NamedArea<T>() {
            @Contract(pure = true)
            public boolean containsNamed(String name, T point) {
                for (String i : names) {
                    if ((name == null) ? i == null : name.equals(i)) {
                        return true;
                    }
                }
                return false;
            }

            public boolean contains(Map.Entry<String, T> point) {
                return this.containsNamed(point.getKey(), point.getValue());
            }
        };
    }

    @Contract("-> fail")
    private ConstantAreas() {
        throw new UnsupportedOperationException();
    }
}
