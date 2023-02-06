package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import model.Circle;
import model.Cross;
import model.Ellipse;
import model.Hexagons;
import model.Line;
import model.Rectangle;
import model.Shapes;
import model.Square;
import model.Triangle;

/**
 * A test class for testing model.
 * 
 * @author 200010781
 *
 */
public class ModelTests {
    private Shapes shape;
    // private GuiDelegate gui;
    private int[] start = { 0, 0 };
    private int[] end = { 10, 10 };

    @Before
    public void setup() {
        // create a shape before test.
        shape = new Shapes();
    }

    @Test
    public void testShapeExists() {
        // test whether a shape exists or not.
        assertNotNull(shape);
    }

    @Test
    public void testShapeAttributes() {
        // test shape's attributes.
        shape.createShape("Line", Color.red, start, end, false);
        assertEquals(shape.getName(), "Line");
        assertEquals(shape.getColor(), Color.red);
        assertEquals(shape.getStart(), start);
        assertEquals(shape.getEnd(), end);
        assertEquals(shape.getSolid(), false);

    }

    @Test
    public void testLine() {
        // test line class
        Shapes line = new Line(Color.red, start, end, true);
        assertNotNull(line.getShape());
    }

    @Test
    public void testEllipse() {
        // test ellipse class
        Shapes ellipse = new Ellipse(Color.red, start, end, false);
        assertNotNull(ellipse.getShape());
    }

    @Test
    public void testRectangle() {
        // test rectangle class
        Shapes rectangle = new Rectangle(Color.red, start, end, false);
        assertNotNull(rectangle.getShape());
    }

    @Test
    public void testCross() {
        // test cross class
        Shapes cross = new Cross(Color.red, start, end, false);
        assertNotNull(cross.getShape());
    }

    @Test
    public void testTriangle() {
        // test triangle class
        Shapes triangle = new Triangle(Color.red, start, end, false);
        assertNotNull(triangle.getShape());
    }

    @Test
    public void testSquare() {
        // test square class
        Shapes square = new Square(Color.red, start, end, false);
        assertNotNull(square.getShape());

    }

    @Test
    public void testCircle() {
        // test circle class
        Shapes circle = new Circle(Color.red, start, end, false);
        assertNotNull(circle.getShape());
    }

    @Test
    public void testHexagons() {
        // test hexagons class
        Shapes hexagons = new Hexagons(Color.red, start, end, false);
        assertNotNull(hexagons.getShape());
    }

    @Test
    public void testPushShape() {
        // test pushShape function
        Shapes line = new Line(Color.red, start, end, true);
        shape.pushShape(line);
        assertEquals(shape.getStoreShape().size(), 1);
    }

    @Test
    public void testPopStore() {
        // test popStore function
        Shapes line = new Line(Color.red, start, end, true);
        shape.pushShape(line);
        assertEquals(shape.getStoreShape().size(), 1);
        shape.popStore();
        assertEquals(shape.getStoreShape().size(), 0);
        assertEquals(shape.getDeleteShape().size(), 1);
    }

    @Test
    public void testPushStore() {
        // test pushStore function
        Shapes line = new Line(Color.red, start, end, true);
        shape.pushShape(line);
        assertEquals(shape.getStoreShape().size(), 1);
        shape.popStore();
        assertEquals(shape.getStoreShape().size(), 0);
        assertEquals(shape.getDeleteShape().size(), 1);
        shape.pushStore();
        assertEquals(shape.getStoreShape().size(), 1);
        assertEquals(shape.getDeleteShape().size(), 0);
    }

    @Test
    public void testClearStore() {
        // test clearStore function
        Shapes line = new Line(Color.red, start, end, true);
        Shapes rectangle = new Rectangle(Color.red, start, end, true);
        shape.pushShape(line);
        shape.pushShape(rectangle);
        assertEquals(shape.getStoreShape().size(), 2);

        shape.popStore();
        assertEquals(shape.getStoreShape().size(), 1);
        assertEquals(shape.getDeleteShape().size(), 1);

        shape.clearStore();
        assertEquals(shape.getStoreShape().size(), 0);
        assertEquals(shape.getDeleteShape().size(), 0);
    }
}
