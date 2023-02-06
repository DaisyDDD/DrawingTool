package model;

import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A class for different shape.
 * 
 * @author 200010781
 *
 */
public class Shapes {

    public interface Listener {
        void update(Stack<Shapes> shapes, boolean solid);

    }

    private ArrayList<Listener> listeners;
    private Color color;
    private int[] start = new int[2];
    private int[] end = new int[2];
    private boolean solid = false;
    private String name;
    private Stack<Shapes> storeShape = new Stack<Shapes>();
    private Stack<Shapes> deleteShape = new Stack<Shapes>();
    private Shape shape;

    /**
     * A constructor for creating shapes.
     */
    public Shapes() {
        listeners = new ArrayList<Listener>();
    }

    /**
     * A method for adding listeners.
     * 
     * @param listener GUI listener.
     */
    public void addListener(Listener listener) {
        listeners.add(listener);
//        System.out.print(listeners.size());
    }

    /**
     * A method for create shapes.
     * 
     * @param name  Shape name.
     * @param color Shape color.
     * @param start Shape start position.
     * @param end   Shape end position.
     * @param solid Shape is filled or not.
     */
    public void createShape(String name, Color color, int[] start, int[] end, boolean solid) {
        this.setName(name);
        this.setColor(color);
        this.setStart(start);
        this.setEnd(end);
        this.setSolid(solid);
        System.out.println("createShape:" + name);

        switch (name) {
        case "Line":
            Shapes line = new Line(color, start, end, solid);
            line.setName(name);
            pushShape(line);
            break;
        case "Ellipse":
            Shapes ellipse = new Ellipse(color, start, end, solid);
            pushShape(ellipse);
            break;
        case "Rectangle":
            Shapes rectangle = new Rectangle(color, start, end, solid);
            pushShape(rectangle);
            break;
        case "Cross":
            Shapes polyline = new Cross(color, start, end, solid);
            polyline.setName(name);
            pushShape(polyline);
            break;
        case "Triangle":
            Shapes triangle = new Triangle(color, start, end, solid);
            pushShape(triangle);
            break;
        case "Square":
            Shapes square = new Square(color, start, end, solid);
            pushShape(square);
            break;
        case "Circle":
            Shapes circle = new Circle(color, start, end, solid);
            pushShape(circle);
            break;
        case "Hexagons":
            Shapes hexagons = new Hexagons(color, start, end, solid);
            pushShape(hexagons);
            break;
        }

        changed();

    }

    /**
     * A method to push shape.
     * 
     * @param shape Created shape that need to be pushed into stack.
     */
    public void pushShape(Shapes shape) {
        storeShape.push(shape);
        System.out.println("pushShape:" + shape);
    }

    /**
     * A method for updating listeners.
     */
    public void changed() {
        // System.out.println(listeners.size());
        for (Listener listener : listeners) {
            System.out.println("changed" + storeShape.size());
            listener.update(storeShape, solid);
        }
    }

    /**
     * A method for pop shapes from stack.
     */
    public void popStore() {
        if (storeShape.size() > 0) {
            Shapes shape = storeShape.pop();
            deleteShape.push(shape);
            System.out.println("changedpop" + storeShape.size());
            changed();
        }

    }

    /**
     * A method for push shapes into stack.
     */
    public void pushStore() {
        if (deleteShape.size() > 0) {
            Shapes shape = deleteShape.pop();
            pushShape(shape);
            System.out.println("changedpush" + storeShape.size());
            changed();
        }

    }

    /**
     * A method to clear stacks.
     */
    public void clearStore() {
        storeShape.clear();
        deleteShape.clear();
        System.out.println("changedclear" + storeShape.size());
        changed();
    }

    /**
     * A method for getting start positions.
     * 
     * @return Start positions array.
     */
    public int[] getStart() {
        return start;
    }

    /**
     * A method for setting start positions.
     * 
     * @param start Start positions array.
     */
    public void setStart(int[] start) {
        this.start = start;
    }

    /**
     * A method for getting end positions.
     * 
     * @return End positions array.
     */
    public int[] getEnd() {
        return end;
    }

    /**
     * A method for setting end positions.
     * 
     * @param end End positions array.
     */
    public void setEnd(int[] end) {
        this.end = end;
    }

    /**
     * A method for getting color.
     * 
     * @return Shape color;
     */
    public Color getColor() {
        return color;
    }

    /**
     * A method for setting shape color.
     * 
     * @param color Shape color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * A method for getting whether a shape is filled or not.
     * 
     * @return boolean state for whether a shape is filled or not.
     */
    public boolean getSolid() {
        return solid;
    }

    /**
     * A method for setting shape filled state.
     * 
     * @param solid Shape is filled or not.
     */
    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    /**
     * A method for getting shape.
     * 
     * @return Shape in this shape.
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * A method for setting shape.
     * 
     * @param shape Shape in this object.
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * A method for getting name.
     * 
     * @return Name of the shape.
     */
    public String getName() {
        return name;
    }

    /**
     * A method for setting shape name.
     * 
     * @param name Name of the shape.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method for getting stacks of storing shape.
     * 
     * @return
     */
    public Stack<Shapes> getStoreShape() {
        return storeShape;
    }

    /**
     * A method for getting stacks of deleting shape.
     * 
     * @return
     */
    public Stack<Shapes> getDeleteShape() {
        return deleteShape;
    }

    /**
     * A method for getting listeners of this model.
     * 
     * @return
     */
    public List<Listener> getListener() {
        return listeners;
    }

}
