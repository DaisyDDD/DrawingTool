package guiDelegate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import model.Shapes;

/**
 * A class for react button and mouse actions.
 * 
 * @author DaisyDai
 *
 */
public class DrawMouse extends JFrame implements ActionListener, MouseListener {

    /**
     * An object of model shape.
     */
    private Shapes shape;
    /**
     * A int array to store start position.
     */
    private int[] start = new int[2];
    /**
     * A int array to store end position.
     */
    private int[] end = new int[2];
    /**
     * A boolean variable to get if it's filled or not.
     */
    private boolean solid = false;
    /**
     * A String variable to get the shape name.
     */
    private String name = "";
    /**
     * A Color variable to get the shape color.
     */
    private Color color;

    /**
     * A constructor for creating a DrawMouse object.
     * 
     * @param shape Model object.
     */
    public DrawMouse(Shapes shape) {
        this.shape = shape;
    }

    /**
     * A method for processing button actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Color")) {// color chooser button

            JColorChooser chooser = new JColorChooser(Color.black);
            Color color = chooser.showDialog(DrawMouse.this, "Choose Color", Color.black);
            if (color == null) {
                color = Color.black;
            }
            this.color = color;
//            JButton click = (JButton) e.getSource();
//            color = click.getBackground();

        } else if (e.getActionCommand().equals("")) { // color buttons
            JButton click = (JButton) e.getSource();
            color = click.getBackground();

        } else { // tool button
            String button = e.getActionCommand();

            if (button.equals("Fill")) {
                JRadioButton solid = (JRadioButton) e.getSource();
                System.out.print(solid.isSelected());
                if (solid.isSelected()) {
                    this.solid = true;
                } else {
                    this.solid = false;
                }
            } else {
                name = button;
            }

            if (name.equals("Undo")) {
                shape.popStore();
            } else if (name.equals("Redo")) {
                shape.pushStore();
            } else if (name.equals("Clear")) {
                shape.clearStore();
            }

        }

    }

    /**
     * A method for dealing with mouse click actions.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * A method for dealing with mouse press actions.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        start[0] = e.getX();
        start[1] = e.getY();
        System.out.println("Mouse pressed " + start[0] + " " + start[1]);
    }

    /**
     * A method for dealing with mouse release actions.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        end[0] = e.getX();
        end[1] = e.getY();
        System.out.println("Mouse released " + end[0] + " " + end[1]);

        if (name.equals("")) {
        } else if (name.equals("Undo")) {
        } else if (name.equals("Redo")) {
        } else if (name.equals("Clear")) {
        } else {
            shape.createShape(name, color, start, end, solid);// model
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
