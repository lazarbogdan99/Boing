/**
 * Triangle.java
 * @version 2.0.0
 * @author Lazar Bogdan
 */
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


/**
 * Triangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the lower left corner of
 * the triangles's bounding rectangle.
 */
public class Triangle extends ClosedShape{
    //The coordinates  horizontally
    private double[] xPos = new double[3];
    //The coordinates vertically
    private double[] yPos = new double[3];
    //The side of the triangle
    private int side;
    //Variable which holds a coppy
    private int firstSide;

    /**
     * Creates a triangle.
     * @param shape holds the shape
     * @param insertionTime The time spent for inserting a shape
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param color The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param pulse True if it pulses,false if not
     */
    public Triangle(String shape, int insertionTime, int x, int y, int vx, int vy, int side, Color color, boolean isFilled, boolean pulse){
        super(shape,insertionTime, x, y, vx, vy, color, isFilled, pulse);
        setSide(side);
        setFirstSide();
        setCoordinates(x,y, side);
    }

    /**
     * This method sets the coordinates of the triangle
     * Here i used a formula to find out where the last point is m=(y2-y1)/(x2-x1) and y2 is the unknown point
     * @param x1 The first horizontal coordinate
     * @param y1 The first vertical coordinate
     * @param side The side of the triangle
     */
    public void setCoordinates(double x1, double y1, int side){
        this.side = side;
        this.xPos[0] = x1;
        this.yPos[0] = y1;

        this.xPos[1] = this.xPos[0] + side;
        this.yPos[1] = this.yPos[0];

        this.xPos[2] = (this.xPos[0] + this.xPos[1]) / 2;
        this.yPos[2] = this.xPos[2] - this.xPos[0] + this.yPos[0];
    }

    /**
     * This method sets the side
     * @param side The side of triangle
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * This method gets the side of the triangle
     * @return the side of the triangle
     */
    public int getSide() {
        return side;
    }

    /**
     * This method sets the initial side of the triangle
     */
    public void setFirstSide() {
        this.firstSide = side;
    }

    /**
     * This method gets the initial side of the triangle
     * @return the initial side of the triangle
     */
    public int getFirstSide() {
        return firstSide;
    }

    /**
     * This method gets the width  of the triangle
     * @return the side
     */
    @Override
    public int getWidth() {
        return side;
    }

    /**
      * This method gets the height of the triangle
     * @return the side
     */
    @Override
    public int getHeight() {
        return side;
    }

    /**
     * This method gets the shape
     * @return the shape
     */
    public String getShape() {
        return this.shape;
    }

    /**
     * This method checks if the shape is in between horizontal bounds
     * @return true if the shape is,false if not
     */
    @Override
    public boolean outOfBoundsX(double winX){
        return (this.xPos[1] > winX) || (this.xPos[0] < 0);
    }
    /**
     * This method checks if the shape is in between vertical bounds
     * @return true if the shape is,false if not
     */
    @Override
    public boolean outOfBoundsY(double winY){
        return (this.yPos[2] > winY) || (this.yPos[0] < 0);
    }

    /**
     *This method puts the shape in bounds if the shape crosses the horizontal bounds
     */
    @Override
    public void putInBoundsX (double winX) {
        if (this.xPos[0] < 0){
            this.xPos[0] = 0;
            setCoordinates(this.xPos[0], this.yPos[0],side);
        }
        if (this.xPos[1] > this.xPos[0] + getWidth()) {
            this.xPos[1] = (int) (winX - Math.ceil (this.getWidth ()));
            setCoordinates(this.xPos[0], this.yPos[0], side);
        }
    }

    /**
     *This method puts the shape in bounds if the shape crosses the vertical bounds
     */
    @Override
    public void putInBoundsY (double winY) {
        if (this.yPos[2] > winY){
            this.yPos[2] = winY;
        }
        if (this.yPos[0] < 0) {
            this.yPos[0] = 0;
            setCoordinates(this.xPos[0], this.yPos[0],side);
        }
    }

    /**
     * This method moves the trinagle
     */
    @Override
    public void move() {
        for(int i = 0; i < 3; i++){
            this.xPos[i] += xVec;
            this.yPos[i] += yVec;



        }
    }

    /**
     * Draw the triangle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(xPos, yPos, 3);
        }
        else {
            g.strokePolygon(xPos, yPos, 3);
        }
    }
}
