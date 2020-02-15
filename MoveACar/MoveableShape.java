import java.awt.Graphics2D;

public interface MoveableShape {

	/**
	 * Draws the shape
	 * @param g2 the graphics context
	 */
	
	void draw (Graphics2D g2);
	void move ();
}
