package Project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Main {
	static int width = 1000; // ����ȭ�� �ʺ�
	static int height = 640; // ����ȭ�� ����
	static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	// �������� �����쿡 ǥ�õ� �� ��ġ�� �����ϱ� ����
	// ���� ������� �ػ� ���� �޾ƿ�
	static int f_x = (int) (screen.getWidth() / 2 - width / 2);
	static int f_y = (int) (screen.getHeight() / 2 - height / 2);
	static int x = 100; // ĳ������ �ʱ� ��ġ x
	static int y = 100; // ĳ������ �ʱ� ��ġ y

	static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	// ���� �� ��ֹ��� ���� �迭
	static Enemy enemy;

	static GameKey key = new GameKey(); // Ű �̺�Ʈ�� ������ ��� �ִ� �ɹ�����
	static int time = 0; // GameThread Ŭ������ �������� ����ð��� ����� ����
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
