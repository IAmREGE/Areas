package rege.rege.areas.impl.simple2d;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point2d;

public class SimpleRectangleArea implements Area<Point2d> {
    @Contract(value = "_, _ -> new", pure = true)
    public static SimpleRectangleArea ofUnit(int x, int y) {
        return new SimpleRectangleArea(
            x, y, x + 1., y + 1., true, true, true, true
        );
    }

    public final double x1;
    public final double y1;
    public final double x2;
    public final double y2;
    public final boolean x1EdgeContained;
    public final boolean y1EdgeContained;
    public final boolean x2EdgeContained;
    public final boolean y2EdgeContained;

    @Contract(pure = true)
    public SimpleRectangleArea(
        double x1, double y1, double x2, double y2, boolean x1EdgeContained,
        boolean y1EdgeContained, boolean x2EdgeContained,
        boolean y2EdgeContained
    ) {
        if (x1 > x2) {
            this.x1 = x2;
            this.x2 = x1;
            this.x1EdgeContained = x2EdgeContained;
            this.x2EdgeContained = x1EdgeContained;
        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.x1EdgeContained = x1EdgeContained;
            this.x2EdgeContained = x2EdgeContained;
        }
        if (y1 > y2) {
            this.y1 = y2;
            this.y2 = y1;
            this.y1EdgeContained = y2EdgeContained;
            this.y2EdgeContained = y1EdgeContained;
        } else {
            this.y1 = y1;
            this.y2 = y2;
            this.y1EdgeContained = y1EdgeContained;
            this.y2EdgeContained = y2EdgeContained;
        }
    }

    public boolean contains(Point2d point) {
        return ((this.x1EdgeContained) ? point.x >= this.x1 :
                (point.x > this.x1)) &&
               ((this.x2EdgeContained) ? point.x <= this.x2 :
                (point.x < this.x2)) &&
               ((this.y1EdgeContained) ? point.y >= this.y1 :
                (point.y > this.y1)) &&
               ((this.y2EdgeContained) ? point.y <= this.y2 :
                (point.y < this.y2));
    }
}
