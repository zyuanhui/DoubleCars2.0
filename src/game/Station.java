package game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**��վ��ը��*/
public class Station {
	public static final int DISTANCE = 200;  //�ѳ�վ֮��ľ��붨��Ϊ����������ά��
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;  //һ�г�վ���õ�y����
	
	public Station(int n) throws Exception{	
		image=ImageIO.read(
				  getClass().getResource("S.png"));
		width = 30;
		height = 60;
		y = -n*DISTANCE-height;
	}
	
	/**��վ��ը���ƶ�*/
	public void step() {
		y++;
	}
}
