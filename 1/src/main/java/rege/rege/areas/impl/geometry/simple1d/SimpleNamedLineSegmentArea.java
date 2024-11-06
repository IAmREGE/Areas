package rege.rege.areas.impl.geometry.simple1d;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.util.NamedArea;

public class SimpleNamedLineSegmentArea implements NamedArea<Double> {
    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static SimpleNamedLineSegmentArea
    ofUnit(String name, int x, boolean x1CornerContained,
           boolean x2CornerContained) {
        return new SimpleNamedLineSegmentArea(
            name, x, x + 1., x1CornerContained, x2CornerContained
        );
    }

    public final String name;
    public final double x1;
    public final double x2;
    public final boolean x1CornerContained;
    public final boolean x2CornerContained;

    @Contract(pure = true)
    public SimpleNamedLineSegmentArea(String name, double x1, double x2,
                                      boolean x1CornerContained,
                                      boolean x2CornerContained) {
        this.name = name;
        if (x1 > x2) {
            this.x1 = x2;
            this.x2 = x1;
            this.x1CornerContained = x2CornerContained;
            this.x2CornerContained = x1CornerContained;
        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.x1CornerContained = x1CornerContained;
            this.x2CornerContained = x2CornerContained;
        }
    }

    public boolean containsNamed(String name, Double point) {
        return ((name == null) ? this.name == null : name.equals(this.name)) &&
               ((this.x1CornerContained) ? point >= this.x1 :
                (point > this.x1)) &&
               ((this.x2CornerContained) ? point <= this.x2 :
                (point < this.x2));
    }

    public boolean contains(Map.Entry<String, Double> point) {
        return this.containsNamed(point.getKey(), point.getValue());
    }
}
