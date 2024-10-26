package rege.rege.areas.impl.transform1d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;

public class Symmertric1dArea implements Area<Double> {
    @NotNull
    public final Area<Double> original;
    public final double center;

    @Contract(pure = true)
    public Symmertric1dArea(@NotNull Area<Double> original, double center) {
        this.original = original;
        this.center = center;
    }

    public boolean contains(Double point) {
        return this.original.contains(this.center - point.doubleValue());
    }
}
