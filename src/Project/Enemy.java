package Project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	private int x; // ��ֹ� x ��ġ
	private int y; // ��ֹ� y ��ġ
	private Image img = new ImageIcon("img/ghost.png").getImage();
	private int move = (int) (Math.random() * 2);

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawEnemy(Graphics g) {
		g.drawImage(img, x, y, null);
	} // ��ֹ� �̹����� �׷���

	public void move() {
		this.x -= 20 + move; // 0.02�� ���� 4+(0~2) �����̰� ��
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
