package rege.rege.areas.impl.combine4d;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import rege.rege.areas.base.Area;
import rege.rege.areas.util.geometry.point.Point3d;
import rege.rege.areas.util.geometry.point.Point4d;

public class Combined3d1dArea implements Area<Point4d> {
    public static enum Mode {
        XYZ, XYW, XZY, XZW, XWY, XWZ, YXZ, YXW, YZX, YZW, YWX, YWZ,
        ZXY, ZXW, ZYX, ZYW, ZWX, ZWY, WXY, WXZ, WYX, WYZ, WZX, WZY;
    }

    @NotNull
    public final Area<Point3d> as3d;
    @NotNull
    public final Area<Double> as1d;
    @NotNull
    public final Mode axisMapMode;

    @Contract(pure = true)
    public
    Combined3d1dArea(@NotNull Area<Point3d> as3d, @NotNull Area<Double> as1d,
                     @NotNull Mode axisMapMode) {
        this.as3d = as3d;
        this.as1d = as1d;
        this.axisMapMode = axisMapMode;
    }

    public boolean contains(Point4d point) {
        switch (this.axisMapMode) {
            case XYZ: return this.as3d.contains(new Point3d(
                point.x, point.y, point.z
            )) && this.as1d.contains(point.w);
            case XYW: return this.as3d.contains(new Point3d(
                point.x, point.y, point.w
            )) && this.as1d.contains(point.z);
            case XZY: return this.as3d.contains(new Point3d(
                point.x, point.z, point.y
            )) && this.as1d.contains(point.w);
            case XZW: return this.as3d.contains(new Point3d(
                point.x, point.z, point.w
            )) && this.as1d.contains(point.y);
            case XWY: return this.as3d.contains(new Point3d(
                point.x, point.w, point.y
            )) && this.as1d.contains(point.z);
            case XWZ: return this.as3d.contains(new Point3d(
                point.x, point.w, point.z
            )) && this.as1d.contains(point.y);
            case YXZ: return this.as3d.contains(new Point3d(
                point.y, point.x, point.z
            )) && this.as1d.contains(point.w);
            case YXW: return this.as3d.contains(new Point3d(
                point.y, point.x, point.w
            )) && this.as1d.contains(point.z);
            case YZX: return this.as3d.contains(new Point3d(
                point.y, point.z, point.x
            )) && this.as1d.contains(point.w);
            case YZW: return this.as3d.contains(new Point3d(
                point.y, point.z, point.w
            )) && this.as1d.contains(point.x);
            case YWX: return this.as3d.contains(new Point3d(
                point.y, point.w, point.x
            )) && this.as1d.contains(point.z);
            case YWZ: return this.as3d.contains(new Point3d(
                point.y, point.w, point.z
            )) && this.as1d.contains(point.x);
            case ZXY: return this.as3d.contains(new Point3d(
                point.z, point.x, point.y
            )) && this.as1d.contains(point.w);
            case ZXW: return this.as3d.contains(new Point3d(
                point.z, point.x, point.w
            )) && this.as1d.contains(point.y);
            case ZYX: return this.as3d.contains(new Point3d(
                point.z, point.y, point.x
            )) && this.as1d.contains(point.w);
            case ZYW: return this.as3d.contains(new Point3d(
                point.z, point.y, point.w
            )) && this.as1d.contains(point.x);
            case ZWX: return this.as3d.contains(new Point3d(
                point.z, point.w, point.x
            )) && this.as1d.contains(point.y);
            case ZWY: return this.as3d.contains(new Point3d(
                point.z, point.w, point.y
            )) && this.as1d.contains(point.x);
            case WXY: return this.as3d.contains(new Point3d(
                point.w, point.x, point.y
            )) && this.as1d.contains(point.z);
            case WXZ: return this.as3d.contains(new Point3d(
                point.w, point.x, point.z
            )) && this.as1d.contains(point.y);
            case WYX: return this.as3d.contains(new Point3d(
                point.w, point.y, point.x
            )) && this.as1d.contains(point.z);
            case WYZ: return this.as3d.contains(new Point3d(
                point.w, point.y, point.z
            )) && this.as1d.contains(point.x);
            case WZX: return this.as3d.contains(new Point3d(
                point.w, point.z, point.x
            )) && this.as1d.contains(point.y);
            case WZY: return this.as3d.contains(new Point3d(
                point.w, point.z, point.y
            )) && this.as1d.contains(point.x);
        }
        return false;
    }
}
