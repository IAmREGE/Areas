package rege.rege.areas.impl.simple1d;

import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.Interval;

public class SimpleInterval implements Area<Double> {
    @NotNull
    private final Interval[] INTVS;

    public SimpleInterval(Interval... intvs) {
        int rl = 0;
        for (Interval i : intvs) {
            if (i != null) {
                rl++;
            }
        }
        this.INTVS = new Interval[rl];
        rl = 0;
        int rn = 0;
        for (Interval i : intvs) {
            if (i != null) {
                this.INTVS[rl] = intvs[rn];
                rl++;
            }
            rn++;
        }
    }

    public boolean contains(Double point) {
        for (Interval i : this.INTVS) {
            if (i.contains(point.doubleValue())) {
                return true;
            }
        }
        return false;
    }
}
