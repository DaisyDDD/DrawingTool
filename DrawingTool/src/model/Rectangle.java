package model;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * A class for Rectangle shape
 * 
 * @author 200010781
 *
 */
public class Rectangle extends Shapes {

    private Rectangle2D rectangle;

    /**
     * A constructor for creating a rectangle.
     * 
     * @param color Rectangle color.
     * @param start Rectangle start positions.
     * @param end   Rectangle end positions.
     * @param solid Rectangle is filled or not.
     */
    public Rectangle(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            rectangle = new Rectangle2D.Double(start[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[1] - start[1]));
        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            rectangle = new Rectangle2D.Double(end[0], end[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[1] - start[1]));
        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"
            rectangle = new Rectangle2D.Double(start[0], end[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[1] - start[1]));
        } else { // Mouse move like "/"
            rectangle = new Rectangle2D.Double(end[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[1] - start[1]));
        }
        this.setShape(rectangle);

    }
//
//    public Rectangle2D getShape() {
//        return rectangle;
//    }
}
