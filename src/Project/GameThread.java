package Project;

public class GameThread extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				productionEnemy();
				Main.key.keyProcess();
				EnemyMove();
				Main.time += 20;
				Thread.sleep(20);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void productionEnemy() {
		if (Main.time % 2000 == 0 || Main.time == 100) {
			for (int i = 0; i < 4; i++) {
				int random = (int) (Math.random() * 2000);
				Enemy enemy = new Enemy(800 + random, 100 + i * 100);
				Main.enemyList.add(enemy);
			}
		}
	}

	public void EnemyMove() {
		for (int i = 0; i < Main.enemyList.size(); i++) {
			Enemy enemy = Main.enemyList.get(i);
			enemy.move();
		}
	}

	public void close() {
		this.interrupt();
	}
}
