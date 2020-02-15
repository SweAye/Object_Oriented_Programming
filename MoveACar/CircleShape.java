import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class CircleShape implements Icon {

	
	
	public CircleShape (int radius)
	{
		
		this.radius = radius;
		
	}
		
		@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return radius;
	}
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return radius;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y,radius,radius);//x+width*6, y+width/3, width/6, width/6);
		g2.setColor(Color.MAGENTA);
		g2.fill(circle);
		
	}
	private int radius;
	
}
