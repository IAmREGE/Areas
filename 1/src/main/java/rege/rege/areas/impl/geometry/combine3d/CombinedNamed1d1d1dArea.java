package rege.rege.areas.impl.geometry.combine3d;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;
import rege.rege.areas.util.NamedPoint;
import rege.rege.areas.util.geometry.point.Point3d;

public class CombinedNamed1d1d1dArea implements NamedArea<Point3d> {
    @NotNull
    public final NamedArea<Double> named;
    @NotNull
    public final Area<Double> namelessMost;
    @NotNull
    public final Area<Double> namelessLeast;
    @Nullable
    public final Boolean namedAs;

    @Contract(pure = true)
    public CombinedNamed1d1d1dArea(
        @NotNull NamedArea<Double> asX, @NotNull Area<Double> asY,
        @NotNull Area<Double> asZ
    ) {
        this.named = asX;
        this.namelessMost = asY;
        this.namelessLeast = asZ;
        this.namedAs = Boolean.TRUE;
    }

    @Contract(pure = true)
    public CombinedNamed1d1d1dArea(
        @NotNull Area<Double> asX, @NotNull NamedArea<Double> asY,
        @NotNull Area<Double> asZ
    ) {
        this.named = asY;
        this.namelessMost = asX;
        this.namelessLeast = asZ;
        this.namedAs = null;
    }

    @Contract(pure = true)
    public CombinedNamed1d1d1dArea(
        @NotNull Area<Double> asX, @NotNull Area<Double> asY,
        @NotNull NamedArea<Double> asZ
    ) {
        this.named = asZ;
        this.namelessMost = asX;
        this.namelessLeast = asY;
        this.namedAs = Boolean.FALSE;
    }

    public boolean containsNamed(String name, Point3d point) {
        return (this.namedAs != null) ?
               (this.namedAs.booleanValue() ?
                this.named.containsNamed(name, point.x) &&
                this.namelessMost.contains(point.y) &&
                this.namelessLeast.contains(point.z) :
                this.namelessMost.contains(point.x) &&
                this.namelessLeast.contains(point.y) &&
                this.named.containsNamed(name, point.z)) :
               this.namelessMost.contains(point.x) &&
               this.named.containsNamed(name, point.y) &&
               this.namelessLeast.contains(point.z);
    }

    public boolean contains(Map.Entry<String, Point3d> point) {
        final Point3d POINT = point.getValue();
        return (this.namedAs != null) ?
               (this.namedAs.booleanValue() ?
                this.named.contains(new NamedPoint<Double>(
                    point.getKey(), POINT.x
                )) && this.namelessMost.contains(POINT.y) &&
                this.namelessLeast.contains(POINT.z) :
                this.namelessMost.contains(POINT.x) &&
                this.namelessLeast.contains(POINT.y) && this.named.contains(
                    new NamedPoint<Double>(point.getKey(), POINT.z)
                )) :
               (this.namelessMost.contains(POINT.x) && this.named.contains(
                    new NamedPoint<Double>(point.getKey(), POINT.y)
                ) && this.namelessLeast.contains(POINT.z));
    }
}
