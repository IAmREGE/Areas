package rege.rege.areas.impl.geometry.transform3d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point3d;

public class Translated3dArea implements Area<Point3d> {
    @NotNull
    public final Area<Point3d> original;
    public final double xShift;
    public final double yShift;
    public final double zShift;

    @Contract(pure = true)
    public Translated3dArea(@NotNull Area<Point3d> original, double xShift,
                            double yShift, double zShift) {
        this.original = original;
        this.xShift = xShift;
        this.yShift = yShift;
        this.zShift = zShift;
    }

    public boolean contains(Point3d point) {
        return this.original.contains(new Point3d(
            point.x - this.xShift, point.y - this.yShift, point.z - this.zShift
        ));
    }
}
