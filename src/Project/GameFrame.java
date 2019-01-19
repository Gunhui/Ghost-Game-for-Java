package Project;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame {

	Image me = new ImageIcon("img/knife.png").getImage();
	Image background = new ImageIcon("img/gamePanel.gif").getImage();
	Image screenImage;
	Graphics screenGraphic;
	JLabel timeLabel;
	MyThread mt;
	Jumpingx2 jp = new Jumpingx2();
	GameThread thr; // ������ ������
	static int myScore = 0; // �ʱ� ����
	static int Hit = 0; // ��Ʈ�� ģ Ƚ��

	GameFrame() {
		setTitle("���� ������Ʈ"); // ������ ����
		setSize(Main.width, Main.height); // ������ ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �� �������� ������ ��� gui�� ����
		setResizable(false); // ������ ũ�� ����
		thr = new GameThread();
		addKeyListener(Main.key);
		thr.start(); // ������ ����
		setVisible(true); // gui�� ���̰� ��
		new Main();
		setLocationRelativeTo(null);
		mt = new MyThread();
		mt.start();
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, this); // ����� �׷���
		g.drawImage(me, Main.x, Main.y, this); // ĳ���͸� �׷���
		exposured(g);
		limitPos();
		for (int i = 0; i < Main.enemyList.size(); i++) {
			Enemy enemy = Main.enemyList.get(i);
			enemy.drawEnemy(g);
		}
		drawString((Graphics2D) g);
	} // ȭ�鿡 �׷��� �̺�Ʈ�� ����ϴ� �޼���

	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.width, Main.height); // �ʺ� 800, ���� 600�� ���̹��� ����
		screenGraphic = screenImage.getGraphics(); // screenImage�� Graphics�� ����
		screenGraphic.drawImage(background, 0, 0, this); // screenImage���� ����� �׸�
		// screenGraphic.add(timeLabel, 0, 0, this);
		screenDraw(screenGraphic);// screenImage(�󿩹�)�� ���� screenGraphic�� screenDraw�� �Ű������� ����
		g.drawImage(screenImage, 0, 0, null);// ȭ�鿡 screenImage(�󿩹�)�� �׷��� �̹����� ȭ�鿡 ���
		repaint();// 0.001�� ���� ���� ������ �̹���(screenImage)�� �׸�
	}

	public void drawString(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 24));// �۾�ü�� �۾��� ���� ũ�� ����
		g.drawString("Time : ", 720, 600);// MyScore�� x=570,y=70�� ��ġ�� �׷���
		g.drawString(Integer.toString(mt.getTimer()), 820, 600);// ���� ������ x=700,y=70�� ��ġ�� �׷���
		g.drawString("Enemy : ", 50, 600);// MyLife�� x=20,y=70�� ��ġ�� �׷���
		g.drawString(Integer.toString(Hit), 160, 600);// ���� �������� x=100,y=70�� ��ġ�� �׷���
	}

	public void limitPos() {
		if (Main.x < 0) {
			Main.x = 0;
		} else if (Main.x > 1000) {
			Main.x = 1000;
		}
		if (Main.y < 0) {
			Main.y = 0;
		} else if (Main.y > 470) {
			Main.y = 470;
		}
	}// �÷��̾ �����ϴ� ��ü�� x�� ����:0~760�� ����:20~540������ �����ϼ� �ְ���

	public void exposured(Graphics g) {
		for (int i = 0; i < Main.enemyList.size(); i++) {
			int enemyX = Main.enemyList.get(i).getX(); // ��ֹ� x ��ġ
			int enemyY = Main.enemyList.get(i).getY(); // ��ֹ� y ��ġ
			int exposureX = enemyX - Main.x; // ��ֹ��� ���� �ε��� ���� x
			int exposureY = enemyY - Main.y; // ��ֹ��� ���� �ε��� ���� y
			if ((exposureX > -110 && exposureX < 110) && (exposureY > -49 && exposureY < 49)) {
				Hit++;
				Main.enemyList.remove(i);
				if (mt.getTimer() == 30) {
					try {
						thr.close();
						setVisible(false);
						mt.stop(); // interrupt�� ������ ���� �ʾ� stop���� ��ü
						Rank rank = new Rank();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}