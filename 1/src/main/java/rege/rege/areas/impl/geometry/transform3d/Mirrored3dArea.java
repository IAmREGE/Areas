package rege.rege.areas.impl.geometry.transform3d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.plane.Plane3d;
import rege.rege.areas.util.geometry.point.Point3d;

public class Mirrored3dArea implements Area<Point3d> {
    public static final Plane3d X_EQUALS_0 = new Plane3d(1, 0, 0, 0);
    public static final Plane3d Y_EQUALS_0 = new Plane3d(0, 1, 0, 0);
    public static final Plane3d Z_EQUALS_0 = new Plane3d(0, 0, 1, 0);
    public static final Plane3d Y_EQUALS_X = new Plane3d(1, -1, 0, 0);
    public static final Plane3d Z_EQUALS_X = new Plane3d(1, 0, -1, 0);
    public static final Plane3d Z_EQUALS_Y = new Plane3d(0, 1, -1, 0);

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofFlippedX(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, Y_EQUALS_0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofFlippedY(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, X_EQUALS_0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofFlippedZ(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, Z_EQUALS_0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofSwappedXY(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, Y_EQUALS_X);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofSwappedXZ(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, Z_EQUALS_X);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored3dArea ofSwappedYZ(@NotNull Area<Point3d> original) {
        return new Mirrored3dArea(original, Z_EQUALS_Y);
    }

    @NotNull
    public final Area<Point3d> original;
    @NotNull
    public final Plane3d plane;

    @Contract(pure = true)
    public
    Mirrored3dArea(@NotNull Area<Point3d> original, @NotNull Plane3d plane) {
        this.original = original;
        this.plane = plane;
    }

    public boolean contains(Point3d point) {
        return this.original.contains(this.plane.getSymmertricPoint(
            point.x, point.y, point.z
        ));
    }
}
