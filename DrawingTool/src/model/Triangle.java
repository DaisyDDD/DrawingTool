package model;

import java.awt.Color;
import java.awt.geom.GeneralPath;

/**
 * A class for Triangle shape.
 * 
 * @author 200010781
 *
 */
public class Triangle extends Shapes {
    private GeneralPath polyline;

    /**
     * A constructor for creating a triangle.
     * 
     * @param color Triangle color.
     * @param start Triangle start positions.
     * @param end   Triangle end positions.
     * @param solid Triangle is filled or not.
     */
    public Triangle(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);

        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, start.length + 2);

        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            polyline.moveTo(start[0] + Math.abs(end[0] - start[0]) / 2, start[1]);

            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0] + Math.abs(end[0] - start[0]) / 2, start[1]);
        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            polyline.moveTo(end[0] + Math.abs(end[0] - start[0]) / 2, end[1]);

            polyline.lineTo(start[0], start[1]);
            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(end[0] + Math.abs(end[0] - start[0]) / 2, end[1]);

        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"

            polyline.moveTo(start[0] + Math.abs(end[0] - start[0]) / 2, end[1]);

            polyline.lineTo(start[0], start[1]);
            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(start[0] + Math.abs(end[0] - start[0]) / 2, end[1]);
        } else { // Mouse move like "/"
            polyline.moveTo(end[0] + Math.abs(end[0] - start[0]) / 2, start[1]);

            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(end[0] + Math.abs(end[0] - start[0]) / 2, start[1]);
        }

        this.setShape(polyline);

    }

//    public GeneralPath getShape() {
//        return polyline;
//    }
}
