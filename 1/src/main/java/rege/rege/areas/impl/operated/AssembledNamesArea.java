package rege.rege.areas.impl.operated;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;

public class AssembledNamesArea<T>
implements NamedArea<T>, Map<String, Area<T>> {
    @NotNull
    private final HashMap<String, Area<T>> areaMap;

    public AssembledNamesArea(@NotNull Map<String, Area<T>> areaMap)
    throws NullPointerException {
        this.areaMap = new HashMap<String, Area<T>>(areaMap);
        for (Entry<String, Area<T>> i : this.areaMap.entrySet()) {
            if (i.getValue() == null) {
                throw new NullPointerException(i.getKey());
            }
        }
    }

    public int size() {
        return this.areaMap.size();
    }

    public boolean isEmpty() {
        return this.areaMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.areaMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.areaMap.containsValue(value);
    }

    public Area<T> get(Object key) {
        return this.areaMap.get(key);
    }

    @Contract("_, _ -> fail")
    public Area<T> put(String key, Area<T> value) {
        throw new IllegalStateException();
    }

    @Contract("_ -> fail")
    public Area<T> remove(Object key) {
        throw new IllegalStateException();
    }

    @Contract("_ -> fail")
    public void putAll(@NotNull Map<? extends String, ? extends Area<T>> t) {
        throw new IllegalStateException();
    }

    @Contract("-> fail")
    public void clear() {
        throw new IllegalStateException();
    }

    @NotNull
    public Set<String> keySet() {
        return new KeySet(this.areaMap);
    }

    @NotNull
    public Collection<Area<T>> values() {
        return new Values<Area<T>>(this.areaMap);
    }

    @NotNull
    public Set<Entry<String, Area<T>>> entrySet() {
        return new EntrySet<Area<T>>(this.areaMap);
    }

    public boolean containsNamed(String name, T point) {
        return this.areaMap.containsKey(name) &&
               this.areaMap.get(name).contains(point);
    }

    public boolean contains(Entry<String, T> point) {
        final String NAME = point.getKey();
        return this.areaMap.containsKey(NAME) &&
               this.areaMap.get(NAME).contains(point.getValue());
    }

    private static class KeySet extends AbstractSet<String> {
        @NotNull
        private final Map<String, ?> map;

        @Contract(pure = true)
        private KeySet(@NotNull Map<String, ?> map) {
            this.map = map;
        }

        @Contract("-> new")
        @NotNull
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                private final Iterator<String> inner =
                KeySet.this.map.keySet().iterator();

                public boolean hasNext() {
                    return this.inner.hasNext();
                }

                public String next() {
                    return this.inner.next();
                }

                @Contract("-> fail")
                public void remove() {
                    throw new IllegalStateException();
                }
            };
        }

        public int size() {
            return this.map.size();
        }

        public boolean contains(Object o) {
            return this.map.containsKey(o);
        }

        @Contract("_ -> fail")
        public boolean remove(Object o) {
            throw new IllegalStateException();
        }

        @Contract("-> fail")
        public void clear() {
            throw new IllegalStateException();
        }
    }

    private static class Values<T> extends AbstractCollection<T> {
        @NotNull
        private final Map<?, T> map;

        @Contract(pure = true)
        private Values(@NotNull Map<?, T> map) {
            this.map = map;
        }

        @Contract("-> new")
        @NotNull
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private final Iterator<T> inner =
                Values.this.map.values().iterator();

                public boolean hasNext() {
                    return this.inner.hasNext();
                }

                @NotNull
                public T next() {
                    return this.inner.next();
                }

                @Contract("-> fail")
                public void remove() {
                    throw new IllegalStateException();
                }
            };
        }

        public int size() {
            return this.map.size();
        }

        public boolean contains(Object o) {
            return this.map.containsValue(o);
        }

        @Contract("-> fail")
        public void clear() {
            throw new IllegalStateException();
        }
    }

    private static class EntrySet<T> extends AbstractSet<Map.Entry<String,T>> {
        @NotNull
        private final Map<String, T> map;

        @Contract(pure = true)
        private EntrySet(@NotNull Map<String, T> map) {
            this.map = map;
        }

        @Contract("-> new")
        @NotNull
        public Iterator<Map.Entry<String, T>> iterator() {
            return new Iterator<Entry<String, T>>() {
                private final Iterator<Entry<String, T>> inner =
                EntrySet.this.map.entrySet().iterator();

                public boolean hasNext() {
                    return this.inner.hasNext();
                }

                public Entry<String, T> next() {
                    return this.inner.next();
                }

                @Contract("-> fail")
                public void remove() {
                    throw new IllegalStateException();
                }
            };
        }

        @Contract("null -> false")
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> ENT = (Map.Entry<?, ?>)o;
            final Object KEY = ENT.getKey();
            return this.map.containsKey(KEY) &&
                   this.map.get(KEY).equals(ENT.getValue());
        }

        @Contract("_ -> fail")
        public boolean remove(Object o) {
            throw new IllegalStateException();
        }

        public int size() {
            return this.map.size();
        }

        @Contract("-> fail")
        public void clear() {
            throw new IllegalStateException();
        }
    }
}
