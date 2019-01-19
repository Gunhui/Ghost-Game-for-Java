package Project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	private int x; // 장애물 x 위치
	private int y; // 장애물 y 위치
	private Image img = new ImageIcon("img/ghost.png").getImage();
	private int move = (int) (Math.random() * 2);

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drawEnemy(Graphics g) {
		g.drawImage(img, x, y, null);
	} // 장애물 이미지를 그려줌

	public void move() {
		this.x -= 20 + move; // 0.02초 마다 4+(0~2) 움직이게 함
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
