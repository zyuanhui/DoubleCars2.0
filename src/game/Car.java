package game;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**³µ*/
public class Car {
	protected BufferedImage image;
	protected int x;
	protected int y;
	
	public Car() throws Exception{	
		image=ImageIO.read(
				  getClass().getResource("Car.png"));
		y = 450;
	}
}
