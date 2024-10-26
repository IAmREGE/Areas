package rege.rege.areas.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Different
public class Point3d extends Point2d {
    public final double z;

    @Contract(pure = true)
    public Point3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Point3d)) ||
            (o.getClass() != this.getClass() &&
             o.getClass().isAnnotationPresent(Different.class))) {
            return false;
        }
        Point3d that = (Point3d)o;
        return Double.compare(this.x, that.x) == 0 &&
               Double.compare(this.y, that.y) == 0 &&
               Double.compare(this.z, that.z) == 0;
    }

    @Override
    @Contract(pure = true)
    public int hashCode() {
        long temp = super.hashCode();
        int result = (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.z);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }

    @Override
    @Contract(pure = true)
    @NotNull
    public String toString() {
        return Point3d.class.getName() + '{' + "x=" + this.x + ", y=" +
               this.y + ", z=" + this.z + '}';
    }
}
