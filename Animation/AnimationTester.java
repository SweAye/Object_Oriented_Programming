import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;

/**
	   This program implements an animation that moves
	   a car shape.
 */
public class AnimationTester
{
	public static void main(String[] args)
	{
		final JFrame frame = new JFrame();
		MoveableShape shape1 = getCar1();// get first car iconn
		MoveableShape shape2= getCar2();
		label1 = new JLabel(icon1);
		label2 = new JLabel(icon2);
		frame.setLayout(new FlowLayout());
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				frame.add(label1);
				// TODO Auto-generated method stub
				shape1.moveCar(label1,framewidth, shape1,15);		
			
			}
			
		});

		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				frame.add(label1);
				// TODO Auto-generated method stub
				shape2.moveCar(label1,framewidth, shape2,20);
				
			}
		});

		
		
		
		
		//frame.add(label2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		Rectangle rec= frame.getBounds();
		 framewidth = rec.width;
		int frameheight = rec.height;
		System.out.println("Frame width: " + framewidth +"\n"+ "frame height: " + frameheight);

				
		
		t2.start();		
		t1.start();
		try {
			t1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//moveCar(label1,framewidth, shape1);// move first car icon
		//moveCar(label1,framewidth, shape1);// move first car icon
	}
	private static Lock lock = new ReentrantLock();
	private static MoveableShape shape1;
	private static MoveableShape shape2;
	private static int framewidth = 0;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	//private static final MoveableShape shape= null;// will use differnt car later
	private static Icon icon1 = null;
	private static Icon icon2 = null;
	private static Icon icon3 = null;
	static JLabel label1 = null;
	static JLabel label2 = null;
	/**
	 * This method will move ever cars with differnt threads
	 * @param label
	 * @param width
	 * @param shape
	 */
	
	



	public static  MoveableShape getCar1(){

		final MoveableShape shape= new CarShape(0, 0, CAR_WIDTH, Color.BLUE);

		icon1 = new ShapeIcon(shape,
				ICON_WIDTH, ICON_HEIGHT);



		return shape;
	}

	public static  MoveableShape getCar2(){

		final MoveableShape shape= new CarShape(0, 0, CAR_WIDTH, Color.RED);

		icon2 = new ShapeIcon(shape,
				ICON_WIDTH, ICON_HEIGHT);



		return shape;
	}





	


}	



