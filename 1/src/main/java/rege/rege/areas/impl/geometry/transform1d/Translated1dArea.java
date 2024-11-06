package rege.rege.areas.impl.geometry.transform1d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class Translated1dArea implements Area<Double> {
    @NotNull
    public final Area<Double> original;
    public final double shift;

    @Contract(pure = true)
    public Translated1dArea(@NotNull Area<Double> original, double shift) {
        this.original = original;
        this.shift = shift;
    }

    public boolean contains(Double point) {
        return this.original.contains(point.doubleValue() - this.shift);
    }
}
