package model;

import java.awt.Color;
import java.awt.geom.GeneralPath;

/**
 * A class for Hexagons shape.
 * 
 * @author 200010781
 *
 */
public class Hexagons extends Shapes {
    private GeneralPath polyline;

    /**
     * A constructor for creating a hexagons.
     * 
     * @param color Hexagons color.
     * @param start Hexagons start positions.
     * @param end   Hexagons end positions.
     * @param solid Hexagons is filled or not.
     */
    public Hexagons(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);

        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, start.length + 2);

        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            polyline.moveTo(start[0], start[1]);

            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(end[0] + Math.abs(end[0] - start[0]) / 2, start[1] + Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(start[0] - Math.abs(end[0] - start[0]) / 2, end[1] - Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(start[0], start[1]);

        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            polyline.moveTo(start[0], start[1]);

            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(end[0] - Math.abs(end[0] - start[0]) / 2, start[1] - Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(start[0] + Math.abs(end[0] - start[0]) / 2, end[1] + Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(start[0], start[1]);

        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"
            polyline.moveTo(start[0], start[1]);

            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(end[0] + Math.abs(end[0] - start[0]) / 2, start[1] - Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(start[0] - Math.abs(end[0] - start[0]) / 2, end[1] + Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(start[0], start[1]);
        } else { // Mouse move like "/"
            polyline.moveTo(start[0], start[1]);

            polyline.lineTo(end[0], start[1]);
            polyline.lineTo(end[0] - Math.abs(end[0] - start[0]) / 2, start[1] + Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(end[0], end[1]);
            polyline.lineTo(start[0], end[1]);
            polyline.lineTo(start[0] + Math.abs(end[0] - start[0]) / 2, end[1] - Math.abs(end[1] - start[1]) / 2);
            polyline.lineTo(start[0], start[1]);
        }

        this.setShape(polyline);
    }

//    public GeneralPath getShape() {
//        return polyline;
//    }
}
