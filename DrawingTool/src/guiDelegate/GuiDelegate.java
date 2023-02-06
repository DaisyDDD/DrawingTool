package guiDelegate;

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

public class GuiDelegate extends JFrame implements Shapes.Listener {

    private Shapes shape;
    private JFrame mainFrame;
    private JToolBar toolbar;
    private JToolBar colorbar;
    private JPanel panel;
    private boolean solid = false;
    private DrawMouse dm;
    private Stack store = new Stack();

    public GuiDelegate(Shapes shape) {
        this.shape = shape;
        this.mainFrame = new JFrame();
        toolbar = new JToolBar();
        colorbar = new JToolBar();
        dm = new DrawMouse(shape);
        setupComponents();

        shape.addListener(this);
    }

    private void setupColorbar() {
        Color[] color = { Color.yellow, Color.blue, Color.red, Color.black, Color.green, Color.gray, Color.orange };

        for (int i = 0; i < color.length; i++) {
            JButton colorBut = new JButton();
            colorBut.setBackground(color[i]);
            // colorBut.setSize(100, 100);
            colorBut.addActionListener(dm);
            colorbar.add(colorBut);

        }
        mainFrame.setVisible(true);

        colorbar.setOrientation(JToolBar.VERTICAL);
        mainFrame.add(colorbar, BorderLayout.WEST);
    }

    private void setupToolbar() {

        JRadioButton solid = new JRadioButton("Solid");
        solid.addActionListener(dm);
        toolbar.add(solid);

        String[] tool = { "Color", "Line", "Rectangle", "Ellipse", "Cross", "Triangle", "Hexagons", "Square", "Circle",
                "Undo", "Redo", "Clear" };

        for (int i = 0; i < tool.length; i++) {
            JButton toolBut = new JButton(tool[i]);
            toolBut.addActionListener(dm);
            toolbar.add(toolBut);
        }

        // add toolbar to north of main frame
        mainFrame.add(toolbar, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setBackground(Color.white);
        mainFrame.add(panel);
    }

    private void setupComponents() {

        mainFrame.setSize(800, 600);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupToolbar();
        setupColorbar();
        mainFrame.addMouseListener(dm);
        mainFrame.addComponentListener(dm);

    }

    @Override
    public void update(Stack<Shapes> shapes, boolean solid) {
        System.out.println("update" + shapes.size());

        Graphics g = mainFrame.getGraphics();
        mainFrame.update(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Shapes shapeEach : shapes) {
            g.setColor(shapeEach.getColor());
            Shape curShape = shapeEach.getShape();
            g2d.draw(curShape);
            if (shapeEach.getSolid()) {
                g2d.fill(curShape);
            }

        }
    }

}
