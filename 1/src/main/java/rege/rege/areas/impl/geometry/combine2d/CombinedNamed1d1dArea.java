package rege.rege.areas.impl.geometry.combine2d;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.NamedArea;
import rege.rege.areas.util.NamedPoint;
import rege.rege.areas.util.geometry.point.Point2d;

public class CombinedNamed1d1dArea implements NamedArea<Point2d> {
    @NotNull
    public final NamedArea<Double> named;
    @NotNull
    public final Area<Double> nameless;
    public final boolean namedAsX;

    @Contract(pure = true)
    public CombinedNamed1d1dArea(@NotNull NamedArea<Double> asX,
                                 @NotNull Area<Double> asY) {
        this.named = asX;
        this.nameless = asY;
        this.namedAsX = true;
    }

    @Contract(pure = true)
    public CombinedNamed1d1dArea(@NotNull Area<Double> asX,
                                 @NotNull NamedArea<Double> asY) {
        this.named = asY;
        this.nameless = asX;
        this.namedAsX = false;
    }

    public boolean containsNamed(String name, Point2d point) {
        return this.namedAsX ?
               this.named.containsNamed(name, point.x) &&
               this.nameless.contains(point.y) :
               this.nameless.contains(point.x) &&
               this.named.containsNamed(name, point.y);
    }

    public boolean contains(Map.Entry<String, Point2d> point) {
        final Point2d POINT = point.getValue();
        return this.namedAsX ? this.named.contains(new NamedPoint<Double>(
                   point.getKey(), POINT.x
               )) && this.nameless.contains(POINT.y) :
               this.nameless.contains(POINT.x) && this.named.containsNamed(
                   point.getKey(), POINT.y
               );
    }
}
