package rege.rege.areas.impl.geometry.transform2d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point2d;

public class Translated2dArea implements Area<Point2d> {
    @NotNull
    public final Area<Point2d> original;
    public final double xShift;
    public final double yShift;

    @Contract(pure = true)
    public Translated2dArea(
        @NotNull Area<Point2d> original, double xShift, double yShift
    ) {
        this.original = original;
        this.xShift = xShift;
        this.yShift = yShift;
    }

    public boolean contains(Point2d point) {
        return this.original.contains(new Point2d(
            point.x - this.xShift, point.y - this.yShift
        ));
    }
}
