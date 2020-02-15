
	import java.awt.*;
	import java.awt.geom.*;
	import java.util.*;

import javax.swing.Timer;

	/**
	   A car that can be moved around.
	   These codes are borrowed from the Author's book website
	*/
	public class CarShape implements MoveableShape
	{
	   /**
	      Constructs a car item.
	      @param x the left of the bounding rectangle
	      @param y the top of the bounding rectangle
	      @param width the width of the bounding rectangle
	   */
	   public CarShape(int x, int y, int width, Color color)
	   {
	      this.x = x;
	      this.y = y;
	      this.width = width;
	     this.color = color;
	   }

	   public synchronized void move()
	   {
		   
	      x ++;
	    
	      
	   }
	   
	   /**
	    * This modify the car moving in circle in and out of the frame
	    * @param endOfFrame
	    */
	   
	   public  void reverseMove(int endOfFrame){
		   
		  // if (x >= endOfFrame){
			   System.out.println("moveing object postion is now x: " + x);
			//   x =0;  
		   //}
		   x++;
		   
	   }
	 
	   
	   public synchronized void  draw(Graphics2D g2)
	   {
	      Rectangle2D.Double body
	            = new Rectangle2D.Double(x, y + width / 6, 
	                  width - 1, width / 6);
	      
	      Ellipse2D.Double frontTire
	            = new Ellipse2D.Double(x + width / 6, y + width / 3, 
	                  width / 6, width / 6);
	      Ellipse2D.Double rearTire
	            = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
	                  width / 6, width / 6);

	      // The bottom of the front windshield
	      Point2D.Double r1
	            = new Point2D.Double(x + width / 6, y + width / 6);
	      // The front of the roof
	      Point2D.Double r2
	            = new Point2D.Double(x + width / 3, y);
	      // The rear of the roof
	      Point2D.Double r3
	            = new Point2D.Double(x + width * 2 / 3, y);
	      // The bottom of the rear windshield
	      Point2D.Double r4
	            = new Point2D.Double(x + width * 5 / 6, y + width / 6);
	      Line2D.Double frontWindshield
	            = new Line2D.Double(r1, r2);
	      Line2D.Double roofTop
	            = new Line2D.Double(r2, r3);
	      Line2D.Double rearWindshield
	            = new Line2D.Double(r3, r4);
	      g2.setColor(color);
	      g2.draw(body);
	      g2.draw(frontTire);
	      g2.draw(rearTire);
	      g2.draw(frontWindshield);
	      g2.draw(roofTop);
	      g2.draw(rearWindshield);
	      notifyAll();
	   }
	   
	   public synchronized void moveCar(Component label, int framewidth, MoveableShape shape, int delay){

			
			final int DELAY = delay;
			// Milliseconds between timer ticks
			Timer t = new Timer(DELAY, event ->
			
			{

				shape.reverseMove(framewidth);
				label.repaint();
			});
			t.start();
			
			
			notifyAll();

		}


	   
	   private int x;
	   private int y;
	   private int width;
	   private Color color;
	   
	}

