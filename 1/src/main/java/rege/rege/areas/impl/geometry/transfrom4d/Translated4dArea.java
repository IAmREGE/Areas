package rege.rege.areas.impl.geometry.transfrom4d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point4d;

public class Translated4dArea implements Area<Point4d> {
    @NotNull
    public final Area<Point4d> original;
    public final double xShift;
    public final double yShift;
    public final double zShift;
    public final double wShift;

    @Contract(pure = true)
    public Translated4dArea(@NotNull Area<Point4d> original, double xShift,
                            double yShift, double zShift, double wShift) {
        this.original = original;
        this.xShift = xShift;
        this.yShift = yShift;
        this.zShift = zShift;
        this.wShift = wShift;
    }

    public boolean contains(Point4d point) {
        return this.original.contains(new Point4d(
            point.x - this.xShift, point.y - this.yShift,
            point.z - this.zShift, point.w - this.wShift
        ));
    }
}
