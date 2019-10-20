

/**
 * Oval.java
 * @version 2.0.0
*/

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Oval extends ClosedShape {
    //The width and height of the oval (major and minor axis)
    private int width, height;
    //The initial width
    private int firstWidth;
    //The initial height
    private int firstHeight;

    /**
     * Creates an oval.
     * @param shape Holds a shape
     * @param insertionTime Holds the time a shape is inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the oval (in pixels).
     * @param height The height of the oval (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     * @param pulse True if pulsing,false if not
     */
    public Oval (String shape, int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean pulse) {
        super (shape, insertionTime, x, y, vx, vy, colour, isFilled, pulse);
        this.width = width;
        this.height = height;
        setFirstHeight(height);
        setFirstWidth(width);
    }

    /**
     * Method to convert an oval to a string.
     */
    public String toString () {
        String result = "This is an oval\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * This method sets the initial height
     * @param firstHeight The initial height of the oval
     */
    public void setFirstHeight(int firstHeight) {
        this.firstHeight = firstHeight;
    }

    /**
     *  This method sets the first width
     * @param firstWidth The initial width of the oval
     */
    public void setFirstWidth(int firstWidth) {
        this.firstWidth = firstWidth;
    }

    /**
     * This method gets the initial height
     * @return the initial height of the oval
     */
    public int getFirstHeight() {
        return firstHeight;
    }

    /**
     * This method gets the initial width
     * @return the initial width of the oval
     */
    public int getFirstWidth() {
        return firstWidth;
    }

    /**
     * This method gets the shape
     * @return the shape
     */
    public String getShape() {
        return this.shape;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }

    /**
     * @return The width of the oval.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the oval.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Draw the oval.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillOval( x, y, width, height );
        }
        else {
            g.strokeOval( x, y, width, height );
        }
    }
}
