package rege.rege.areas.util.geometry.line;

public class Line3d {
    public final double x1;
    public final double y1;
    public final double z1;
    public final double a;
    public final double b;
    public final double c;

    public
    Line3d(double x1, double y1, double z1, double a, double b, double c) {
        if (x1 != x1 || y1 != y1 || z1 != z1 || a != a || b != b || c != c ||
            (a == 0. && b == 0. && c == 0.)) {
            throw new IllegalArgumentException();
        }
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
