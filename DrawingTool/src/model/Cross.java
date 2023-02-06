package model;

import java.awt.Color;
import java.awt.geom.GeneralPath;

/**
 * A class for Cross shape
 * 
 * @author 200010781
 *
 */
public class Cross extends Shapes {

    private GeneralPath polyline;

    /**
     * A constructor for creating a cross.
     * 
     * @param color Cross color.
     * @param start Cross start positions.
     * @param end   Cross end positions.
     * @param solid Cross is filled or not.
     */
    public Cross(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);

        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, start.length + 2);

        polyline.moveTo(start[0], start[1]);
        polyline.lineTo(end[0], end[1]);
        polyline.moveTo(start[0], end[1]);
        polyline.lineTo(end[0], start[1]);

        this.setShape(polyline);
    }
//
//    public GeneralPath getShape() {
//        System.out.print("111");
//        return polyline;
//    }
}
