import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class Bubble extends GOval {
    
    // Minimum radius to make bubble
    private static final int MIN_RADIUS = 5;
    
    // Maximum radius to make bubble
    private static final int MAX_RADIUS = 50;
    
    private static RandomGenerator rgen = RandomGenerator.getInstance();
    
    /** Creates a bubble with specified properties.
      * @param cx (double) x-location of centre of bubble.
      * @param cy (double) y-location of centre of bubble.
      * @param r (double) Radius of bubble.
      * @param color (Color) Color of bubble.
      */
   public Bubble(double cx, double cy, double r, Color color) {
   		super(0, 0, 0, 0);
        bubble = new GOval((cx - r), (cy - r), 2*r, 2*r);
        bubble.setFilled(true);
        bubble.setColor(color);
    }

    /** Creates bubble with random properties
      * @param screenWidth (int) width of window in pixels.
      * @param screenHeight (int) Height of window in pixels.
      * @param atBottom (bool) Start bubbles at bottom of screen.
      */
    public Bubble(int screenWidth, int screenHeight, boolean atBottom) {
    	super(0, 0, 0, 0);
        r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
        startx = rgen.nextDouble(0, screenWidth);
        
        if (atBottom == true) {
            starty = screenHeight;            // always start at bottom of screen
        } else {
            starty = rgen.nextDouble(0, screenHeight);
        }

        color = rgen.nextColor();

        bubble = new GOval(startx, starty, 2*r, 2*r);
        bubble.setFilled(true);
        bubble.setColor(color);

        
        vx = 0;
        // Give bubble random y velocity
        vy = rgen.nextDouble(-0.8, 0);
    }

    /** Get the x-position of bubble. */
    public double getX() {
        return (bubble.getX());
    }
	
    /** Get the y-position of bubble. */
    public double getY() {
        return (bubble.getY());
    }

    /** Get x-velocity of bubble. */
	public double getVx() {
		return vx;
	}
	
    /** Get y-velocity of bubble. */
    public double getVy() {
        return vy;
    }
 	
    /** Set x-velocity of bubble. */
 	public void setVx(double velocity) {
 		vx = velocity;
 	}

    /** Set y-velocity of bubble. */
    public void setVy(double velocity) {
        vy = velocity;
    }
    
    /** Get radius of bubble. */
    public double getRadius() {
        return r;
    }
    
    /** Set radius of bubble. */
    public void setRadius(double radius) {
        r = radius;
    }
    
    /** Move bubble in it's current velocity */
    public void moveBubble() {
        bubble.move(vx, vy);
    }
    
    /** Move bubble by specified amount
      * @param dx (double) amount to move in x direction.
      * @param dy (double) amount to move in y direction.
      */
    public void moveBubble(double dx, double dy) {
        bubble.move(dx, dy);
    }
    
    /** Returns the GOval representing the bubble */
    public GOval getBubble() {
    	return bubble;
    }
    
    /* Used to define the starting state of the Bubble.
     * Subsequent states are maintained via GOval methods (getX((, etc.).
     */
    private double startx;
    private double starty;
    private double r;
    private Color color;
    private GOval bubble;

    // X & Y Velocity of bubble
    private double vy;
    private double vx;
}
