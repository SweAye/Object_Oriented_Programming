import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class ShapeIcon implements Icon{

	
	public ShapeIcon (MoveableShape shape, int width, int height){
		
		this.shape = shape;
		this.width = width;
		this.height = height;
	
	}
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
		Graphics2D g2 = (Graphics2D)g;
		shape.draw(g2);
		
	}
	
	private int width;
	private int height;
	private MoveableShape shape;

}
