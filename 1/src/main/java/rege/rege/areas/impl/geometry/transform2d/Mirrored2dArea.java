package rege.rege.areas.impl.geometry.transform2d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.line.Line2d;
import rege.rege.areas.util.geometry.point.Point2d;

public class Mirrored2dArea implements Area<Point2d> {
    public static final Line2d X_EQUALS_0 = new Line2d(1, 0, 0);
    public static final Line2d Y_EQUALS_0 = new Line2d(0, 1, 0);
    public static final Line2d Y_EQUALS_X = new Line2d(1, -1, 0);

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored2dArea ofFlippedX(@NotNull Area<Point2d> original) {
        return new Mirrored2dArea(original, Y_EQUALS_0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored2dArea ofFlippedY(@NotNull Area<Point2d> original) {
        return new Mirrored2dArea(original, X_EQUALS_0);
    }

    @Contract(value = "_ -> new", pure = true)
    public static Mirrored2dArea ofSwappedXY(@NotNull Area<Point2d> original) {
        return new Mirrored2dArea(original, Y_EQUALS_X);
    }

    @NotNull
    public final Area<Point2d> original;
    @NotNull
    public final Line2d line;

    @Contract(pure = true)
    public
    Mirrored2dArea(@NotNull Area<Point2d> original, @NotNull Line2d line) {
        this.original = original;
        this.line = line;
    }

    public boolean contains(Point2d point) {
        return this.original.contains(this.line.getSymmertricPoint(
            point.x, point.y
        ));
    }
}
