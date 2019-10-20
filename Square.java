


/**
 * Square.java
 * @version 2.0.0
 * @author Lazar Bogdan
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */

public class Square extends ClosedShape {
    //The side of the square
    private int side;
    //The initial side
    private int firstSide;


    /**
     * Creates a square.
     * @param shape holds the shape
     * @param insertionTime The time spent for inserting a shape
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param pulse True if it pulses,false if not
     */
    public Square (String shape, int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean pulse) {
        super (shape, insertionTime, x, y, vx, vy, colour, isFilled, pulse);
        this.side = side;
        setFirstSide(side);

    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * This method sets the initial side of the square
     * @param firstSide The initial side of the square
     */
    public void setFirstSide(int firstSide) {
        this.firstSide = firstSide;
    }

    /**
     * This method gets the initial side of the square
     * @return the initial side of the square
     */
    public int getFirstSide() {
        return firstSide;
    }

    /**
     * This method gets the shape
     * @return the shape
     */
    public String getShape() {
        return this.shape;
    }

    /**
     * This method sets the side of the square
     * @param side The side of the square
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * This method gets the side of the square
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */

    /**
     * This method gets the width of the square
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * This method gets the height of the square
     * @return The height of the square.
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }
}
