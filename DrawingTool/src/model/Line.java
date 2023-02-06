package model;

import java.awt.Color;
import java.awt.geom.Line2D;

/**
 * A class for Line shape.
 * 
 * @author 200010781
 *
 */
public class Line extends Shapes {
    /**
     * A constructor for creating a line.
     * 
     * @param color Line color.
     * @param start Line start positions.
     * @param end   Line end positions.
     * @param solid Line is filled or not.
     */
    public Line(Color color, int[] start, int[] end, boolean solid) {
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        Line2D line = new Line2D.Double(start[0], start[1], end[0], end[1]);
        this.setShape(line);

    }

}