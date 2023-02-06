package model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * A class for Circle shape.
 * 
 * @author 200010781
 *
 */
public class Circle extends Shapes {
    private Ellipse2D ellipse;

    /**
     * A constructor for creating a circle.
     * 
     * @param color Circle color.
     * @param start Circle start positions.
     * @param end   Circle end positions.
     * @param solid Circle is filled or not.
     */
    public Circle(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            ellipse = new Ellipse2D.Double(start[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[0] - start[0]));
        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            ellipse = new Ellipse2D.Double(end[0], end[1], Math.abs(end[0] - start[0]), Math.abs(end[0] - start[0]));
        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"
            ellipse = new Ellipse2D.Double(start[0], end[1], Math.abs(end[0] - start[0]), Math.abs(end[0] - start[0]));
        } else { // Mouse move like "/"
            ellipse = new Ellipse2D.Double(end[0], start[1], Math.abs(end[0] - start[0]), Math.abs(end[0] - start[0]));
        }

        this.setShape(ellipse);
    }
//
//    public Ellipse2D getShape() {
//        return ellipse;
//    }
}
