package rege.rege.areas.impl.geometry.combine3d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point2d;
import rege.rege.areas.util.geometry.point.Point3d;

public class Combined2d1dArea implements Area<Point3d> {
    public static enum Mode {
        XY, XZ, YX, YZ, ZX, ZY;
    }

    @NotNull
    public final Area<Point2d> as2d;
    @NotNull
    public final Area<Double> as1d;
    @NotNull
    public final Mode axisMapMode;

    @Contract(pure = true)
    public
    Combined2d1dArea(@NotNull Area<Point2d> as2d, @NotNull Area<Double> as1d,
                     @NotNull Mode axisMapMode) {
        this.as2d = as2d;
        this.as1d = as1d;
        this.axisMapMode = axisMapMode;
    }

    public boolean contains(Point3d point) {
        switch (this.axisMapMode) {
            case XY: return this.as2d.contains(new Point2d(point.x, point.y))&&
                            this.as1d.contains(point.z);
            case XZ: return this.as2d.contains(new Point2d(point.x, point.z))&&
                            this.as1d.contains(point.y);
            case YX: return this.as2d.contains(new Point2d(point.y, point.x))&&
                            this.as1d.contains(point.z);
            case YZ: return this.as2d.contains(new Point2d(point.y, point.z))&&
                            this.as1d.contains(point.x);
            case ZX: return this.as2d.contains(new Point2d(point.z, point.x))&&
                            this.as1d.contains(point.y);
            case ZY: return this.as2d.contains(new Point2d(point.z, point.y))&&
                            this.as1d.contains(point.x);
        }
        return false;
    }
}
