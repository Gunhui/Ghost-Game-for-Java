package Project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Main {
	static int width = 1000; // 게임화면 너비
	static int height = 640; // 게임화면 높이
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	// 프레임이 윈도우에 표시될 때 위치를 세팅하기 위해
	// 현재 모니터의 해상도 값을 받아옴
	static int f_x = (int) (screen.getWidth() / 2 - width / 2);
	static int f_y = (int) (screen.getHeight() / 2 - height / 2);
	static int x = 100; // 캐릭터의 초기 위치 x
	static int y = 100; // 캐릭터의 초기 위치 y

	static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	// 날라 올 장애물을 담을 배열
	static Enemy enemy;

	static GameKey key = new GameKey(); // 키 이벤트의 정보를 담고 있는 맴버변수
	static int time = 0; // GameThread 클래스의 스레드의 실행시간을 기록할 변수
	static int playTime = 0;
 
	Main() {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.remove(i);
			i--;
		}
	}

	public static void main(String[] args) {
		Jumpingx2 jp = new Jumpingx2();
		// GameFrame gf = new GameFrame();
	}
}
