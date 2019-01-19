package Project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKey extends KeyAdapter{
	
	private boolean keyUp = false;
	private boolean keyDown = false;
	private boolean keyLeft = false;
	private boolean keyRight = false;
	private boolean keySpace = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			keyUp = true; // 위로가기 버튼을 누르면 keyUp이 true가 됨
			break;
		case KeyEvent.VK_DOWN:
			keyDown = true; // 내려가기 버튼을 누르면 keyDown이 true가 됨
			break;
		case KeyEvent.VK_LEFT:
			keyLeft = true; // 왼쪽 버튼을 누르면 keyLeft이 true가 됨
			break;
		case KeyEvent.VK_RIGHT:
			keyRight = true; // 오른쪽 버튼을 누르면 keyRight이 true가 됨
			break;
		case KeyEvent.VK_SPACE:
			keySpace = true; // 스페이스 버튼을 누르면 keySpace이 true가 됨
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			keyUp = false;//위로가기 버튼을 때면 keyUp이 false가됨
			break;
		case KeyEvent.VK_DOWN://위로가기 버튼을 때면 keyDown이 false가됨
			keyDown = false;
			break;
		case KeyEvent.VK_LEFT://위로가기 버튼을 때면 keyLeft이 false가됨
			keyLeft = false;
			break;
		case KeyEvent.VK_RIGHT://위로가기 버튼을 때면 keyRight이 false가됨
			keyRight = false;
			break;
		case KeyEvent.VK_SPACE://위로가기 버튼을 때면 keySpace이 false가됨
			keySpace = false;
			break;
		}
	}
	public void keyProcess() {
		if(keyUp) {
			Main.y -= 9;
		}
		if(keyDown) {
			Main.y += 9;
		}
		if(keyRight) {
			Main.x +=9;
		}
		if(keyLeft) {
			Main.x -=9;
		}
	}//키boolean값이 true이면 플레이어가 움직일수 있게 해주는 메소드
	
	public void keyStop() {
		this.keyUp = false;
		this.keyDown = false;
		this.keyLeft = false;
		this.keyRight = false;
		this.keySpace = false;
	} // 게임을 다시 시작할 때 플레이어가 마음대로 움직이지 않도록 모든 키의 boolean을 false로 설정
}
