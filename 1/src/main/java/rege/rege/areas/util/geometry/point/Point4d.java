package rege.rege.areas.util.geometry.point;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.util.Different;

@Different
public class Point4d extends Point3d {
    public final double w;

    @Contract(pure = true)
    public Point4d(double x, double y, double z, double w) {
        super(x, y, z);
        this.w = w;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Point4d)) ||
            (o.getClass() != this.getClass() &&
             o.getClass().isAnnotationPresent(Different.class))) {
            return false;
        }
        Point4d that = (Point4d)o;
        return Double.compare(this.x, that.x) == 0 &&
               Double.compare(this.y, that.y) == 0 &&
               Double.compare(this.z, that.z) == 0 &&
               Double.compare(this.w, that.w) == 0;
    }

    @Override
    @Contract(pure = true)
    public int hashCode() {
        long temp = super.hashCode();
        int result = (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.w);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }

    @Override
    @Contract(pure = true)
    @NotNull
    public String toString() {
        return Point4d.class.getName() + '{' + "x=" + this.x + ", y=" +
               this.y + ", z=" + this.z + ", w=" + this.w + '}';
    }
}
