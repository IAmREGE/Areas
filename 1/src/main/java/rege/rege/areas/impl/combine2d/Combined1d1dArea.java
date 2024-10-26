package rege.rege.areas.impl.combine2d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.Point2d;

public class Combined1d1dArea implements Area<Point2d> {
    @NotNull
    public final Area<Double> asX;
    @NotNull
    public final Area<Double> asY;

    @Contract(pure = true)
    public
    Combined1d1dArea(@NotNull Area<Double> asX, @NotNull Area<Double> asY) {
        this.asX = asX;
        this.asY = asY;
    }

    public boolean contains(Point2d point) {
        return this.asX.contains(point.x) && this.asY.contains(point.y);
    }
}
