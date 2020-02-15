	import java.awt.*;

	/**
	   A shape that can be moved around.
	   The edited code for reverseMove
	*/
	public interface MoveableShape
	{
	   /**
	      Draws the shape.
	      @param g2 the graphics context
	   */
	   void draw(Graphics2D g2);
	   /**
	      Moves the shape.
	      It is up to the shape to move itself, for example by tracking the time since 
	      its last movement, its position, and velocity.
	   */
	   void move();
	   void reverseMove(int FrameWidth);
	   void moveCar(Component label, int framewidth, MoveableShape shape, int delay);
	  
	}

