package rege.rege.areas.impl.geometry.transform2d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point2d;

public class Rotated2dArea implements Area<Point2d> {
    @Contract(value = "_, _, _ -> new", pure = true)
    public static Rotated2dArea ofCentrosymmertric(
        @NotNull Area<Point2d> original, double centerX, double centerY
    ) {
        return new Rotated2dArea(original, centerX, centerY, Math.PI);
    }

    @NotNull
    public final Area<Point2d> original;
    public final double centerX;
    public final double centerY;
    public final double angle;

    @Contract(pure = true)
    public Rotated2dArea(@NotNull Area<Point2d> original, double centerX,
                         double centerY, double angle) {
        this.original = original;
        this.centerX = centerX;
        this.centerY = centerY;
        this.angle = angle;
    }

    public boolean contains(Point2d point) {
        return this.original.contains(new Point2d(
            ((point.x - this.centerX) * Math.cos(this.angle)) +
            ((point.y - this.centerY) * Math.sin(this.angle)) + this.centerX,
            ((point.y - this.centerY) * Math.cos(this.angle)) -
            ((point.x - this.centerX) * Math.sin(this.angle)) + this.centerY
        ));
    }
}
