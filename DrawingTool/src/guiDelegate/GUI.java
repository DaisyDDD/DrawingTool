package guiDelegate;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import model.Shapes;

/**
 * A GuiDelegate class for creating GUI.
 * 
 * @author 200010781
 *
 */
public class GUI extends JFrame implements Shapes.Listener {

    /**
     * An object of model shape.
     */
    private Shapes shape;
    /**
     * A JFrame object for gui main frame.
     */
    private JFrame mainFrame;
    /**
     * A JToolbar object for gui shapes selecting.
     */
    private JToolBar toolbar;
    /**
     * A JToolbar object for gui color selecting.
     */
    private JToolBar colorbar;
    /**
     * A JPanel object for drawing.
     */
    private JPanel panel;
    /**
     * An object for DrawMouse.
     */
    private DrawMouse dm;

    /**
     * A constructor for creating gui.
     * 
     * @param shape
     */
    public GUI(Shapes shape) {
        this.shape = shape;
        this.mainFrame = new JFrame();
        toolbar = new JToolBar();
        colorbar = new JToolBar();
        dm = new DrawMouse(shape);
        setupComponents();

        shape.addListener(this);
    }

    /**
     * A method for setting color bar.
     */
    private void setupColorbar() {
        Color[] color = { Color.yellow, Color.blue, Color.red, Color.black, Color.green, Color.gray, Color.orange };

        for (int i = 0; i < color.length; i++) { // create color buttons
            JButton colorBut = new JButton();
            // colorBut.setPreferredSize(new Dimension(30, 30));
            colorBut.setBackground(color[i]);

            // colorBut.setSize(100, 100);
            colorBut.addActionListener(dm);
            colorbar.add(colorBut); // add into color bar

        }
        mainFrame.setVisible(true);

        colorbar.setOrientation(JToolBar.VERTICAL);
        mainFrame.add(colorbar, BorderLayout.WEST);
    }

    /**
     * A method for setting tool bar for shapes selecting.
     */
    private void setupToolbar() {

        JRadioButton solid = new JRadioButton("Fill");
        solid.addActionListener(dm);
        toolbar.add(solid);

        String[] tool = { "Color", "Line", "Rectangle", "Ellipse", "Cross", "Triangle", "Hexagons", "Square", "Circle",
                "Undo", "Redo", "Clear" };

        for (int i = 0; i < tool.length; i++) { // create shape buttons
            JButton toolBut = new JButton(tool[i]);
            toolBut.addActionListener(dm);
            toolbar.add(toolBut); // add into tool bar
        }

        // add toolbar to north of main frame
        mainFrame.add(toolbar, BorderLayout.NORTH);
        setupPanel();
    }

    /**
     * A method for setting up panel for drawing.
     */
    private void setupPanel() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        mainFrame.add(panel);
    }

    /**
     * A method for setting up all components in mainFrame.
     */
    private void setupComponents() {

        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupToolbar();
        setupColorbar();
        // setupPanel();
        mainFrame.addMouseListener(dm);

    }

    /**
     * A method for updating main frame when changes happen.
     */
    public void update(Stack<Shapes> shapes, boolean solid) {
        System.out.println("update" + shapes.size());

        Graphics g = mainFrame.getGraphics();
        mainFrame.update(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Shapes shapeEach : shapes) {
            g.setColor(shapeEach.getColor());
            Shape curShape = shapeEach.getShape();
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.draw(curShape);
            if (shapeEach.getSolid()) {
                g2d.fill(curShape);
            }

        }
    }

}
