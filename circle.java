


/**
 * Circle.java
 * @version 2.0.0
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
    //The diameter of the circle
    private int diameter;
    //The first size of diameter
    private int firstDiameter;


    /**
     * Creates a circle.
     * @param shape holds the shape
     * @param insertionTime The time spent for inserting a shape
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param pulse True if it pulses,false if not
     */
    public Circle (String shape, int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean pulse) {
        super (shape, insertionTime, x, y, vx, vy, colour, isFilled, pulse);
        this.diameter = diameter;
        firstDiameter = getDiameter();

    }

    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
        String result = "This is a circle\n";
        result += super.toString ();
        result += "Its diameter is " + this.diameter + "\n";
        return result;
    }

    /**
     * this method sets the first diameter
     * @param firstDiameter first diameter
     */
    public void setFirstDiameter(int firstDiameter) {
        this.firstDiameter = firstDiameter;
    }

    /**
     * this method gets the first diameter and returns it
     * @return first diameter
     */
    public int getFirstDiameter() {
        return firstDiameter;
    }

    /**
     * @param diameter the diameter.
     */
    public void setDiameter (int diameter) {
        this.diameter = diameter;
    }

    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * @return The width of the circle
     */
    public int getWidth() {
        return diameter;
    }

    /**
     * @return The height of the circle
     */
    public int getHeight() {
        return diameter;
    }

    public String getShape() {
        return this.shape;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillOval( x, y, diameter, diameter );
        }
        else {
            g.strokeOval( x, y, diameter, diameter );
        }
    }
}
