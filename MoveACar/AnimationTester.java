import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class AnimationTester {
	public static void main(String[] args){
		JFrame frame = new JFrame();
	//	frame.setSize(500, 500);
		//JFrame frame2 = new JFrame();
		
		//final MoveableShape shape = new CarShape(0,0,CAR_WIDTH);
		final MoveableShape shape2 = new CircleShape(0,0,RADIUS); 
		
		//ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH,ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(shape2,RADIUS,RADIUS);
		
		//final JLabel label = new JLabel(icon);
		final JLabel label2 = new JLabel(icon2);
		
		
		
		frame.setLayout(new FlowLayout());
		//frame.add(label);
		frame.add(label2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
		final int DELAY = 100;
		// this is actionlistner with implementating MoveableShape
	//	Timer t = new Timer(DELAY,event ->{
		//	shape2.move();
			//label.repaint();
			//label2.repaint();
		//});
		//t.start();
		
		
		
		
	}
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
	private static final int RADIUS = 50;

}
