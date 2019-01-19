package Project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class jump {
	private long time = System.currentTimeMillis();
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String date = dayTime.format(new Date(time));
	private int score = 0;
	private String name;
	private static int timer = 0;

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public long getTime() {
		return time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTime(long time) {
		this.time = time;
	}
}