package rege.rege.areas.util.geometry.line;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.util.geometry.point.Point2d;

public class Line2d {
    @NotNull
    public static Line2d ofSlopeInterceptForm(double k, double b) {
        return new Line2d(k, -1, b);
    }

    @NotNull
    public static Line2d ofInterceptForm(double a, double b) {
        return new Line2d(1. / a, 1. / b, -1);
    }

    @NotNull
    public static Line2d ofPointSlopeForm(double k, double x1, double y1) {
        return new Line2d(k, -1, y1 - (k * x1));
    }

    public final double a;
    public final double b;
    public final double c;

    public Line2d(double a, double b, double c)
    throws IllegalArgumentException {
        if (a != a || b != b || c != c || (a == 0. && b == 0.)) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public Point2d getSymmertricPoint(double x, double y) {
        return new Point2d(
            x - (2 * this.a * ((this.a * x) + (this.b * y) + this.c) /
                 ((this.a * this.a) + (this.b * this.b))),
            y - (2 * this.b * ((this.a * x) + (this.b * y) + this.c) /
                 ((this.a * this.a) + (this.b * this.b)))
        );
    }

    @Contract(pure = true)
    public double getSlope() {
        return (this.b != 0) ? -this.a / this.b : Double.NaN;
    }
}
