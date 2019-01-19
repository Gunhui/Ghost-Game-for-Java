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
	GameThread thr; // 게임의 스레드
	static int myScore = 0; // 초기 점수
	static int Hit = 0; // 배트로 친 횟수

	GameFrame() {
		setTitle("개인 프로젝트"); // 프레임 제목
		setSize(Main.width, Main.height); // 프레임 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이 프레임을 닫으면 모든 gui가 닫힘
		setResizable(false); // 프레임 크기 고정
		thr = new GameThread();
		addKeyListener(Main.key);
		thr.start(); // 스레드 실행
		setVisible(true); // gui를 보이게 함
		new Main();
		setLocationRelativeTo(null);
		mt = new MyThread();
		mt.start();
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, this); // 배경을 그려줌
		g.drawImage(me, Main.x, Main.y, this); // 캐릭터를 그려줌
		exposured(g);
		limitPos();
		for (int i = 0; i < Main.enemyList.size(); i++) {
			Enemy enemy = Main.enemyList.get(i);
			enemy.drawEnemy(g);
		}
		drawString((Graphics2D) g);
	} // 화면에 그려질 이벤트를 담당하는 메서드

	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.width, Main.height); // 너비가 800, 높이 600인 빈이미지 생성
		screenGraphic = screenImage.getGraphics(); // screenImage를 Graphics로 만듬
		screenGraphic.drawImage(background, 0, 0, this); // screenImage위에 배경을 그림
		// screenGraphic.add(timeLabel, 0, 0, this);
		screenDraw(screenGraphic);// screenImage(빈여백)을 얻은 screenGraphic를 screenDraw의 매개변수로 넣음
		g.drawImage(screenImage, 0, 0, null);// 화면에 screenImage(빈여백)에 그려진 이미지를 화면에 출력
		repaint();// 0.001초 마다 새로 설정된 이미지(screenImage)를 그림
	}

	public void drawString(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 24));// 글씨체와 글씨의 굵기 크기 설정
		g.drawString("Time : ", 720, 600);// MyScore를 x=570,y=70의 위치에 그려줌
		g.drawString(Integer.toString(mt.getTimer()), 820, 600);// 나의 점수를 x=700,y=70의 위치에 그려줌
		g.drawString("Enemy : ", 50, 600);// MyLife를 x=20,y=70의 위치에 그려줌
		g.drawString(Integer.toString(Hit), 160, 600);// 나의 라이프를 x=100,y=70의 위치에 그려줌
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
	}// 플레이어가 조작하는 기체가 x축 기준:0~760축 기준:20~540까지만 움직일수 있게함

	public void exposured(Graphics g) {
		for (int i = 0; i < Main.enemyList.size(); i++) {
			int enemyX = Main.enemyList.get(i).getX(); // 장애물 x 위치
			int enemyY = Main.enemyList.get(i).getY(); // 장애물 y 위치
			int exposureX = enemyX - Main.x; // 장애물과 내가 부딪힌 판정 x
			int exposureY = enemyY - Main.y; // 장애물과 내가 부딪힌 판정 y
			if ((exposureX > -110 && exposureX < 110) && (exposureY > -49 && exposureY < 49)) {
				Hit++;
				Main.enemyList.remove(i);
				if (mt.getTimer() == 30) {
					try {
						thr.close();
						setVisible(false);
						mt.stop(); // interrupt가 실행이 되지 않아 stop으로 대체
						Rank rank = new Rank();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}