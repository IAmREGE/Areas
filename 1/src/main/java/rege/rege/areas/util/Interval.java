package rege.rege.areas.util;

import java.util.Arrays;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Interval {
    @Nullable
    public static Interval closed(double left, double right)
    throws IllegalArgumentException {
        return (left > right) ? null : new Interval(left, right, true, true);
    }

    @Nullable
    public static Interval open(double left, double right)
    throws IllegalArgumentException {
        return (left >= right) ? null :new Interval(left, right, false, false);
    }

    @NotNull
    public static Interval le(double right) throws IllegalArgumentException {
        return new Interval(Double.NEGATIVE_INFINITY, right, true, true);
    }

    @NotNull
    public static Interval lt(double right) throws IllegalArgumentException {
        return new Interval(Double.NEGATIVE_INFINITY, right, true, false);
    }

    @NotNull
    public static Interval ge(double left) throws IllegalArgumentException {
        return new Interval(left, Double.POSITIVE_INFINITY, true, true);
    }

    @NotNull
    public static Interval gt(double left) throws IllegalArgumentException {
        return new Interval(left, Double.POSITIVE_INFINITY, false, true);
    }

    @NotNull
    public static Interval one(double val) throws IllegalArgumentException {
        return new Interval(val, val, true, true);
    }

    public final double left;
    public final double right;
    public final boolean leftClosed;
    public final boolean rightClosed;

    public Interval(double left, double right, boolean leftClosed,
                    boolean rightClosed) throws IllegalArgumentException {
        if (Double.isNaN(left) || Double.isNaN(right) || left > right ||
            ((!(leftClosed && rightClosed)) && left == right)) {
            throw new IllegalArgumentException(
                "attempt to new an empty interval"
            );
        }
        this.left = left;
        this.right = right;
        this.leftClosed = leftClosed;
        this.rightClosed = rightClosed ;
    }

    @Override
    public String toString() {
        return (this.left != this.right) ?
               (this.leftClosed ? "[" : "(") + this.left + "," + this.right +
               (this.rightClosed ? "]" : ")") : ("{" + this.left + "}");
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval)o;
        return Double.compare(this.left, interval.left) == 0 &&
               Double.compare(this.right, interval.right) == 0 &&
               this.leftClosed == interval.leftClosed &&
               this.rightClosed == interval.rightClosed;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{
            this.left, this.right, this.leftClosed, this.rightClosed
        });
    }

    @Contract(pure = true)
    public boolean contains(double num) {
        return ((this.leftClosed) ? num >= this.left : (num > this.left)) &&
               ((this.rightClosed) ? num <= this.right : (num < this.right));
    }
}
