package main;

import javax.swing.JPanel;

import guiDelegate.GUI;
import model.Shapes;

/**
 * A class for Main method which can be promoted.
 * 
 * @author 200010781
 * @version 1
 */
public class DrawingMain extends JPanel {

    /**
     * A main method to run this Project.
     * 
     * @param args User input. Expected to be null.
     */
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        GUI delegate = new GUI(shape);

    }

}
