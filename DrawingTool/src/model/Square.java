package model;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * A class for Square shape
 * 
 * @author 200010781
 *
 */
public class Square extends Shapes {
    private Rectangle2D rectangle;

    /**
     * A constructor for creating a square.
     * 
     * @param color Square color.
     * @param start Square start positions.
     * @param end   Square end positions.
     * @param solid Square is filled or not.
     */
    public Square(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        if (start[0] <= end[0] && start[1] <= end[1]) { // Mouse move like "\"
            rectangle = new Rectangle2D.Double(start[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[0] - start[0]));
        } else if (start[0] >= end[0] && start[1] >= end[1]) { // Mouse move like "\"
            rectangle = new Rectangle2D.Double(end[0], end[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[0] - start[0]));
        } else if (start[0] <= end[0] && start[1] >= end[1]) { // Mouse move like "/"
            rectangle = new Rectangle2D.Double(start[0], end[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[0] - start[0]));
        } else { // Mouse move like "/"
            rectangle = new Rectangle2D.Double(end[0], start[1], Math.abs(end[0] - start[0]),
                    Math.abs(end[0] - start[0]));
        }

        this.setShape(rectangle);
    }

//    public Rectangle2D getShape() {
//        return rectangle;
//    }
}
