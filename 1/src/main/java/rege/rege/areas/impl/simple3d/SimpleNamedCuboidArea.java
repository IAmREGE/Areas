package rege.rege.areas.impl.simple3d;

import java.util.Map;

import org.jetbrains.annotations.Contract;
import rege.rege.areas.util.NamedArea;
import rege.rege.areas.util.geometry.point.Point3d;

public class SimpleNamedCuboidArea implements NamedArea<Point3d> {
    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static SimpleNamedCuboidArea ofUnit(String name, int x, int y, int z) {
        return new SimpleNamedCuboidArea(name, x, y, z, x + 1., y + 1., z + 1.,
                                         true, true, true, true, true, true);
    }

    public final String name;
    public final double x1;
    public final double y1;
    public final double z1;
    public final double x2;
    public final double y2;
    public final double z2;
    public final boolean x1FaceContained;
    public final boolean y1FaceContained;
    public final boolean z1FaceContained;
    public final boolean x2FaceContained;
    public final boolean y2FaceContained;
    public final boolean z2FaceContained;

    @Contract(pure = true)
    public SimpleNamedCuboidArea(
        String name, double x1, double y1, double z1, double x2, double y2,
        double z2, boolean x1FaceContained, boolean y1FaceContained,
        boolean z1FaceContained, boolean x2FaceContained,
        boolean y2FaceContained, boolean z2FaceContained
    ) {
        this.name = name;
        if (x1 > x2) {
            this.x1 = x2;
            this.x2 = x1;
            this.x1FaceContained = x2FaceContained;
            this.x2FaceContained = x1FaceContained;
        } else {
            this.x1 = x1;
            this.x2 = x2;
            this.x1FaceContained = x1FaceContained;
            this.x2FaceContained = x2FaceContained;
        }
        if (y1 > y2) {
            this.y1 = y2;
            this.y2 = y1;
            this.y1FaceContained = y2FaceContained;
            this.y2FaceContained = y1FaceContained;
        } else {
            this.y1 = y1;
            this.y2 = y2;
            this.y1FaceContained = y1FaceContained;
            this.y2FaceContained = y2FaceContained;
        }
        if (z1 > z2) {
            this.z1 = z2;
            this.z2 = z1;
            this.z1FaceContained = z2FaceContained;
            this.z2FaceContained = z1FaceContained;
        } else {
            this.z1 = z1;
            this.z2 = z2;
            this.z1FaceContained = z1FaceContained;
            this.z2FaceContained = z2FaceContained;
        }
    }

    public boolean containsNamed(String name, Point3d point) {
        return ((name == null) ? this.name == null : name.equals(this.name)) &&
               ((this.x1FaceContained) ? point.x >= this.x1 :
                (point.x > this.x1)) &&
               ((this.x2FaceContained) ? point.x <= this.x2 :
                (point.x < this.x2)) &&
               ((this.y1FaceContained) ? point.y >= this.y1 :
                (point.y > this.y1)) &&
               ((this.y2FaceContained) ? point.y <= this.y2 :
                (point.y < this.y2)) &&
               ((this.z1FaceContained) ? point.z >= this.z1 :
                (point.z > this.z1)) &&
               ((this.z2FaceContained) ? point.z <= this.z2 :
                (point.z < this.z2));
    }

    public boolean contains(Map.Entry<String, Point3d> point) {
        return this.containsNamed(point.getKey(), point.getValue());
    }
}
