package game;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**ը��*/
public class Tnt {
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public Tnt(int n) throws Exception{
		image=ImageIO.read(
				  getClass().getResource("T.png"));
		width = 20;
		height = 40;
		y = -n*Station.DISTANCE-height-10;
	}
	
	/**ը���ƶ�*/
	public void step() {
		y++;
	}
}
