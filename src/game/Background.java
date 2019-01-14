package game;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**ÓÎÏ·±³¾°*/
public class Background {
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	protected int y1;
	protected int speed;
	public Background() throws Exception {
		image = ImageIO.read(
		  getClass().getResource("bg.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 0;
		y = 0;
		y1 = -600;
	}
	
	/**±³¾°ÒÆ¶¯*/
	public void step() {
		y++;
		y1++;
		if(y>=600) {
			y=-600;
		}
		if(y1>=600) {
			y1=-600;
		}
	}
}
