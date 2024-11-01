package rege.rege.areas.impl.simple2d;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point2d;

public class SimpleEllipseArea implements Area<Point2d> {
    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static SimpleEllipseArea
    ofCircle(double x, double y, double radius, boolean closed) {
        return (Math.abs(x) < Math.abs(y)) ? new SimpleEllipseArea(
            x, y, x, y, (x > 0.) ? x - radius : (x + radius), y, closed
        ) : new SimpleEllipseArea(
            x, y, x, y, x, (y > 0.) ? y - radius : (y + radius), closed
        );
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static SimpleEllipseArea
    ofUnitCircle(double x, double y, boolean closed) {
        return ofCircle(x, y, 1, closed);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static SimpleEllipseArea
    ofStandardEllipse(double a, double b, boolean closed) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a > b) {
            double c = Math.sqrt(a * a - (b * b));
            return new SimpleEllipseArea(c, 0, -c, 0, 0, b, closed);
        }
        if (a < b) {
            double c = Math.sqrt(b * b - (a * a));
            return new SimpleEllipseArea(0, c, 0, -c, a, 0, closed);
        }
        return ofCircle(0, 0, a, closed);
    }

    public final double f1x;
    public final double f1y;
    public final double f2x;
    public final double f2y;
    public final double ox;
    public final double oy;
    public final boolean closed;

    @Contract(pure = true)
    public SimpleEllipseArea(double f1x, double f1y, double f2x, double f2y,
                             double ox, double oy, boolean closed) {
        this.f1x = f1x;
        this.f1y = f1y;
        this.f2x = f2x;
        this.f2y = f2y;
        this.ox = ox;
        this.oy = oy;
        this.closed = closed;
    }

    public boolean contains(Point2d point) {
        double xmf1x = point.x - this.f1x;
        double ymf1y = point.y - this.f1y;
        double xmf2x = point.x - this.f2x;
        double ymf2y = point.y - this.f2y;
        double oxmf1x = this.ox - this.f1x;
        double oymf1y = this.oy - this.f1y;
        double oxmf2x = this.ox - this.f2x;
        double oymf2y = this.oy - this.f2y;
        double left = Math.sqrt(xmf1x * xmf1x + (ymf1y * ymf1y)) +
                      Math.sqrt(xmf2x * xmf2x + (ymf2y * ymf2y));
        double right = Math.sqrt(oxmf1x * oxmf1x + (oymf1y * oymf1y)) +
                       Math.sqrt(oxmf2x * oxmf2x + (oymf2y * oymf2y));
        return this.closed ? left <= right : (left < right);
    }
}
