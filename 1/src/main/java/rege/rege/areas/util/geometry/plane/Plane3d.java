package rege.rege.areas.util.geometry.plane;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.util.geometry.point.Point3d;

public class Plane3d {
    public final double a;
    public final double b;
    public final double c;
    public final double d;

    public Plane3d(double a, double b, double c, double d)
    throws IllegalArgumentException {
        if (a != a || b != b || c != c || d != d ||
            (a == 0. && b == 0. && c == 0.)) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public Point3d getSymmertricPoint(double x, double y, double z) {
        return new Point3d(x - (
            2 * this.a * ((this.a * x) + (this.b * y) + (this.c * z) + this.d)/
            ((this.a * this.a) + (this.b * this.b) + (this.c * this.c))
        ), y - (
            2 * this.b * ((this.a * x) + (this.b * y) + (this.c * z) + this.d)/
            ((this.a * this.a) + (this.b * this.b) + (this.c * this.c))
        ), z - (
            2 * this.c * ((this.a * x) + (this.b * y) + (this.c * z) + this.d)/
            ((this.a * this.a) + (this.b * this.b) + (this.c * this.c))
        ));
    }
}
