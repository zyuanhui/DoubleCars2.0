package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GO extends JPanel implements KeyListener{
	private Background bg;
	private Car car1;
	private Car car2;
	private Station[] station; //s0,s1,s2,s3,s4,s5,s6,s7,s8,s9;
	private Tnt[] tnt; //t0,t1,t2,t3,t4,t5,t6,t7,t8,t9;
	private int[] s,t;
	private int code;
	private int score;
	
	public GO() throws Exception {
		//��վ��ը������ʱ��x����
		s = new int[] {45,75,195,225};
		t = new int[] {50,80,200,230};
		//����
		bg = new Background();
		//��̨��
		car1 = new Car();
		car1.x = 78;
		car2 = new Car();
		car2.x = 228;
		//��ʼ��10����վ��10��ը��
		station = new Station[8];
		tnt = new Tnt[8];
		for(int i=0;i<station.length;i++) {
			station[i] = new Station(i/2);  //���θ�Station�Ĺ��췽��
			tnt[i] = new Tnt(i/2);			//���θ�Tnt�Ĺ��췽��
		}
		//����߳���ը����x���긳ֵ
		for(int i=0;i<station.length;i+=2) {
			int index = (int)(Math.random()*2);
			station[i].x = s[index];
			if(index==0) {
				tnt[i].x = t[1];
			}else {
				tnt[i].x = t[0];
			}
		}
		//���ұ߳���ը����x���긳ֵ
		for(int i=1;i<station.length;i+=2) {
			int index = (int)(Math.random()*2+2);
			station[i].x = s[index];
			if(index==2) {
				tnt[i].x = t[3];
			}else {
				tnt[i].x = t[2];
			}
		}
	}
	
	public void action() throws Exception {
		int on = 0;
		int off = 1;
		int on_off = on;
		//������Ϸ����
		while(on_off==on) {
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			bg.step();
			for(int i=0;i<station.length;i++) {
				station[i].step();;
				tnt[i].step();;
			}
			//ÿ�г�վ��ը�������������ڶ�����������
			for(int i=0;i<station.length;i+=2) {
				if(station[i].y==600) {
					station[i].y = -Station.DISTANCE;
					station[i+1].y = -Station.DISTANCE;
					tnt[i].y = -190;
					tnt[i+1].y = -190;
					int indexLeft = (int)(Math.random()*2);
					station[i].x = s[indexLeft];
					if(station[i].x==s[0]) {
						tnt[i].x = t[1];
					}else {
						tnt[i].x = t[0];
					}
					int indexRight = (int)(Math.random()*2+2);
					station[i+1].x = s[indexRight];
					if(station[i+1].x==s[2]) {
						tnt[i+1].x = t[3];
					}else {
						tnt[i+1].x = t[2];
					}
				}
			}
			
			//�÷�
			for(int i=0;i<station.length;i++) {
				if(car1.y==station[i].y || car2.y==station[i].y) {
					score++;
				}
			}
			//����ը����Ϸ����
			for(int i=0;i<station.length;i++) {
				if((car1.y==tnt[i].y+40 && car1.x==tnt[i].x-2) || (car2.y==tnt[i].y+40 && car2.x==tnt[i].x-2)) {
					on_off = off;
				}
			}
			//A��D��������ߵĳ������ƶ�
			if(code==65) {
				car1.x = 48;
			}else if(code==68) {
				car1.x = 78;
			}
			//���͡��������ұߵĳ������ƶ�
			if(code==37) {
				car2.x = 198;
			}else if(code==39) {
				car2.x = 228;
			}
			repaint();
		}
		
	}
	public void paint(Graphics g) {
		g.drawImage(bg.image,bg.x,bg.y,null);
		//��10����վ��10��ը��
		for(int i=0;i<station.length;i++) {
			g.drawImage(station[i].image,station[i].x,station[i].y,null);
			g.drawImage(tnt[i].image,tnt[i].x,tnt[i].y,null);
		}
		g.setColor(Color.ORANGE);
		g.drawLine(148,0,148,600);
		g.drawLine(149,0,149,600);
		g.drawLine(150,0,150,600);
		g.drawLine(151,0,151,600);
		g.drawLine(152,0,152,600);
		g.setColor(Color.WHITE);
		g.drawLine(75,0,75,600);
		g.drawLine(225,0,225,600);
		g.drawImage(car1.image,car1.x,car1.y,null);
		g.drawImage(car2.image,car2.x,car2.y,null);
		Font f = new Font(Font.SANS_SERIF,Font.BOLD,50);
		g.setFont(f);
		g.setColor(Color.black);
		g.drawString(""+score,30,80);
		g.setColor(Color.WHITE);
		g.drawString(""+score,28,78);
	}
	
	//��Ϸ���
	public static void main(String[] args) throws Exception {
		//�������f
		JFrame f = new JFrame("2Car_2.0");
		f.setSize(306, 628);
//		f.setUndecorated(true); //�ޱ߿�
		f.setLocationRelativeTo(null); //����
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		GO go = new GO();
		f.add(go);
//		f.setResizable(false); //���ܵ��ڴ�С
		f.setVisible(true);
		f.addKeyListener(go);
		go.addKeyListener(go);
		go.action();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		code = e.getKeyCode();
//		System.out.println(code);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
