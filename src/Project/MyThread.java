package Project;

public class MyThread extends Thread {
	private int timer = 0;
	jump jp = new jump();

	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
				timer = i;
				jp.setTimer(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(timer);
		}
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

}
