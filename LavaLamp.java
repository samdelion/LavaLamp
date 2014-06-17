import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class LavaLamp extends GraphicsProgram {

    // Number of bubbles to have on-screen at any one time
    private static final int NUM_BUBBLES = 20;

    // Time to run simulation for (milliseconds)
    private static final int TIME = 100000;
    
    // Time between frames (milliseconds)
    private static final int DELAY = 10;
    
    private static int screenWidth;
    private static int screenHeight;

    public void run() {
        // Time spent in simulation
        int timePassed = 0;

        screenWidth = getWidth();
        screenHeight = getHeight();

        // Create NUM_BUBBLES bubbles
        createBubbles();
        setBackground(rgen.nextColor());
        
        println(bubbles[1].getX());
        waitForClick();
        
        // Continue simulation while time passed not greater than TIME
        while (timePassed < TIME) {
            moveBubbles();
            checkIfExit();
            pause(DELAY);
            timePassed += DELAY;

			// Cycle background color
            if (timePassed % 750 == 0) {
                setBackground(rgen.nextColor());
            }
        }
    }
    
    // Creates NUM_BUBBLES randomly positioned on the screen
    private void createBubbles() {
        bubbles = new Bubble[NUM_BUBBLES];

        for (int i = 0; i < NUM_BUBBLES; ++i) {
            bubbles[i] = new Bubble(screenWidth, screenHeight, false);
            
            // Add bubble to canvas
            add(bubbles[i].getBubble());
        }
    }
    
    private void moveBubbles() {
        for (int i = 0; i < NUM_BUBBLES; ++i) {
            bubbles[i].moveBubble();
        }
    }
    
    private void checkIfExit() {
        for (int i = 0; i < NUM_BUBBLES; ++i) {
            // If bubble no longer visible on screen
            if ( (bubbles[i].getY()) < (0 - 2*bubbles[i].getRadius()) ) {
                // Remove bubble from canvas
                remove(bubbles[i].getBubble());
                
                // Overwrite old bubble in memory with new bubble
                bubbles[i] = new Bubble(screenWidth, screenHeight, true);
                
                // Add new bubble to canvas
                add(bubbles[i].getBubble());
            }
        }
    }        

    // Bubble array
    private Bubble[] bubbles;
    
    // Random Generator
    private RandomGenerator rgen = RandomGenerator.getInstance();
            
}
