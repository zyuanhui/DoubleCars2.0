package game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**车站和炸弹*/
public class Station {
	public static final int DISTANCE = 200;  //把车站之间的距离定义为常量，方便维护
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;  //一行车站共用的y坐标
	
	public Station(int n) throws Exception{	
		image=ImageIO.read(
				  getClass().getResource("S.png"));
		width = 30;
		height = 60;
		y = -n*DISTANCE-height;
	}
	
	/**车站和炸弹移动*/
	public void step() {
		y++;
	}
}
