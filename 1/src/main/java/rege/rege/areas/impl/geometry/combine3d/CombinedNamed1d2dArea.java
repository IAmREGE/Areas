package rege.rege.areas.impl.geometry.combine3d;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;
import rege.rege.areas.util.NamedPoint;
import rege.rege.areas.util.geometry.point.Point2d;
import rege.rege.areas.util.geometry.point.Point3d;

public class CombinedNamed1d2dArea implements NamedArea<Point3d> {
    @NotNull
    public final Area<Point2d> as2d;
    @NotNull
    public final NamedArea<Double> as1d;
    @NotNull
    public final Combined2d1dArea.Mode axisMapMode;

    @Contract(pure = true)
    public CombinedNamed1d2dArea(
        @NotNull Area<Point2d> as2d, @NotNull NamedArea<Double> as1d,
        @NotNull Combined2d1dArea.Mode axisMapMode
    ) {
        this.as2d = as2d;
        this.as1d = as1d;
        this.axisMapMode = axisMapMode;
    }

    public boolean containsNamed(String name, Point3d point) {
        switch (this.axisMapMode) {
            case XY: return this.as2d.contains(new Point2d(point.x, point.y))&&
                            this.as1d.containsNamed(name, point.z);
            case XZ: return this.as2d.contains(new Point2d(point.x, point.z))&&
                            this.as1d.containsNamed(name, point.y);
            case YX: return this.as2d.contains(new Point2d(point.y, point.x))&&
                            this.as1d.containsNamed(name, point.z);
            case YZ: return this.as2d.contains(new Point2d(point.y, point.z))&&
                            this.as1d.containsNamed(name, point.x);
            case ZX: return this.as2d.contains(new Point2d(point.z, point.x))&&
                            this.as1d.containsNamed(name, point.y);
            case ZY: return this.as2d.contains(new Point2d(point.z, point.y))&&
                            this.as1d.containsNamed(name, point.x);
        }
        return false;
    }

    public boolean contains(Map.Entry<String, Point3d> point) {
        final String NAME = point.getKey();
        final Point3d POINT = point.getValue();
        switch (this.axisMapMode) {
            case XY: return this.as2d.contains(new Point2d(POINT.x, POINT.y))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.z
                            ));
            case XZ: return this.as2d.contains(new Point2d(POINT.x, POINT.z))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.y
                            ));
            case YX: return this.as2d.contains(new Point2d(POINT.y, POINT.x))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.z
                            ));
            case YZ: return this.as2d.contains(new Point2d(POINT.y, POINT.z))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.x
                            ));
            case ZX: return this.as2d.contains(new Point2d(POINT.z, POINT.x))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.y
                            ));
            case ZY: return this.as2d.contains(new Point2d(POINT.z, POINT.y))&&
                            this.as1d.contains(new NamedPoint<Double>(
                                NAME, POINT.x
                            ));
        }
        return false;
    }
}
