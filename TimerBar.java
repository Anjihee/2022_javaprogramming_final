import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//TimerBar
public class TimerBar extends JLabel implements Runnable {
	//타임바 크기 설정
	int width = 450, height = 50;
	int x = 10, y = 50;
	Color color = new Color(201, 231, 248);
	
	int second;

	public TimerBar(int second) {
		setBackground(color);
		setOpaque(true);
		setBounds(x, y, width, height);
		
		this.second = second;
	}

	//스레드 실행
	@Override
	public void run() {
		while (true) {
			try { //시간 설정
				Thread.sleep(800 / (width / second));
			} catch (Exception e) {
				e.printStackTrace();
			}

			//시간에 따라 너비가 줄어든다.
			if (getWidth() > 0) {
				width -= 1;	// 너비가 1씩 줄어듦
				//System.out.println(width);
				setBounds(x, y, width, height);
			} else {
				//System.out.println("종료");
				break;
			}
		}
	}
}

