package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * A class for Ellipse shape.
 * 
 * @author 200010781
 *
 */
public class Ellipse extends Shapes {

    private Ellipse2D ellipse;

    /**
     * A constructor for creating a ellipse.
     * 
     * @param color Ellipse color.
     * @param start Ellipse start positions.
     * @param end   Ellipse end positions.
     * @param solid Ellipse is filled or not.
     */
    public Ellipse(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            ellipse = new Ellipse2D.Double(start[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[1] - start[1]));
        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            ellipse = new Ellipse2D.Double(end[0], end[1], Math.abs(end[0] - start[0]), Math.abs(end[1] - start[1]));
        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"
            ellipse = new Ellipse2D.Double(start[0], end[1], Math.abs(end[0] - start[0]), Math.abs(end[1] - start[1]));
        } else { // Mouse move like "/"
            ellipse = new Ellipse2D.Double(end[0], start[1], Math.abs(end[0] - start[0]), Math.abs(end[1] - start[1]));
        }
        this.setShape(ellipse);
    }
//
//    public Ellipse2D getShape() {
//        return ellipse;
//    }

}
