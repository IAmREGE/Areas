package rege.rege.areas.impl.geometry.combine3d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point3d;

public class Combined1d1d1dArea implements Area<Point3d> {
    @NotNull
    public final Area<Double> asX;
    @NotNull
    public final Area<Double> asY;
    @NotNull
    public final Area<Double> asZ;

    @Contract(pure = true)
    public
    Combined1d1d1dArea(@NotNull Area<Double> asX, @NotNull Area<Double> asY,
                       @NotNull Area<Double> asZ) {
        this.asX = asX;
        this.asY = asY;
        this.asZ = asZ;
    }

    public boolean contains(Point3d point) {
        return this.asX.contains(point.x) && this.asY.contains(point.y) &&
               this.asZ.contains(point.z);
    }
}
