package rege.rege.areas.util.geometry.point;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.util.Different;

public class Point2d implements Map.Entry<Double, Double> {
    public final double x;
    public final double y;

    @Contract(pure = true)
    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Contract(pure = true)
    @NotNull
    public Double getKey() {
        return this.x;
    }

    @Contract(pure = true)
    @NotNull
    public Double getValue() {
        return this.y;
    }

    @Contract("_ -> fail")
    public Double setValue(Double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((!(o instanceof Point2d)) ||
            (o.getClass() != this.getClass() &&
             o.getClass().isAnnotationPresent(Different.class))) {
            return false;
        }
        Point2d that = (Point2d)o;
        return Double.compare(this.x, that.x) == 0 &&
               Double.compare(this.y, that.y) == 0;
    }

    @Override
    @Contract(pure = true)
    public int hashCode() {
        long temp = Double.doubleToLongBits(this.x);
        int result = (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }

    @Override
    @Contract(pure = true)
    @NotNull
    public String toString() {
        return Point2d.class.getName() + '{' + "x=" + this.x + ", y=" +
               this.y + '}';
    }
}
