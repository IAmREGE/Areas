package rege.rege.areas.impl.geometry.combine4d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point4d;

public class Combined1d1d1d1dArea implements Area<Point4d> {
    @NotNull
    public final Area<Double> asX;
    @NotNull
    public final Area<Double> asY;
    @NotNull
    public final Area<Double> asZ;
    @NotNull
    public final Area<Double> asW;

    @Contract(pure = true)
    public
    Combined1d1d1d1dArea(@NotNull Area<Double> asX, @NotNull Area<Double> asY,
                         @NotNull Area<Double> asZ, @NotNull Area<Double> asW){
        this.asX = asX;
        this.asY = asY;
        this.asZ = asZ;
        this.asW = asW;
    }

    public boolean contains(Point4d point) {
        return this.asX.contains(point.x) && this.asY.contains(point.y) &&
               this.asZ.contains(point.z) && this.asW.contains(point.w);
    }
}
