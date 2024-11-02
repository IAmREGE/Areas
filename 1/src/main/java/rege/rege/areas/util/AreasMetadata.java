package rege.rege.areas.util;

import org.jetbrains.annotations.Contract;

public abstract class AreasMetadata {
    public static final long ITERATION_NUMBER = 1L;
    public static final int VER_MAJOR = 0;
    public static final int VER_MINOR = 0;
    public static final int VER_MICRO = 1;
    public static final char VER_STATE = 'a';
    public static final int VER_DEV_REVISION = 1;
    public static final String VER_STRING =
    (VER_DEV_REVISION == 0) ? VER_MAJOR + "." + VER_MINOR + "." + VER_MICRO :
    VER_MAJOR + "." + VER_MINOR + "." + VER_MICRO + "-" + VER_STATE + "." +
    VER_DEV_REVISION;

    static {
        assert VER_MAJOR >= 0;
        assert VER_MINOR >= 0;
        assert VER_MICRO >= 0;
        assert VER_STATE == 'a' || VER_STATE == 'b' || VER_STATE == 'c' ||
               VER_STATE == 'f' || VER_STATE == 'p';
        assert VER_DEV_REVISION >= 0;
    }

    @Contract("-> fail")
    private AreasMetadata() {
        throw new UnsupportedOperationException();
    }
}
