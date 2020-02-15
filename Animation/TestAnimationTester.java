import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	/**
	   This program implements an animation that moves
	   many car in differnt speed.
	*/

public class TestAnimationTester {
		
	
	   public static void main(String[] args)
	   {
	     final JFrame frame = new JFrame();

	      final MoveableShape shape
	            = new CarShape(0, 0, CAR_WIDTH, Color.DARK_GRAY);

	      ShapeIcon icon = new ShapeIcon(shape,
	            ICON_WIDTH, ICON_HEIGHT);

	   
	      final JLabel label = new JLabel(icon);
	      
	      frame.setLayout(new FlowLayout());
	      frame.add(label);

	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setVisible(true);
	      
	      
	      Rectangle rec= frame.getBounds();
	      int framewidth = rec.width;
	      int frameheight = rec.height;
	      System.out.println("Frame width: " + framewidth +"\n"+ "frame height: " + frameheight);
	      
	      
	      final int DELAY = 10;
	      // Milliseconds between timer ticks
	      Timer t = new Timer(DELAY, event ->
	         {
	        	
	           shape.reverseMove(framewidth);
	            label.repaint();
	         });
	      t.start();
	     
	   }

	   private static final int ICON_WIDTH = 400;
	   private static final int ICON_HEIGHT = 100;
	   private static final int CAR_WIDTH = 100;
	}	
	
	


	
	

