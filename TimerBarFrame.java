import java.awt.*;
import javax.swing.*;

public class TimerBarFrame extends JFrame {
	JPanel panel;
	
	TimerBar timerBar;
	Thread threadBar;
	
	public TimerBarFrame() {
		int second = 2;		// 초
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerBar = new TimerBar(second);
		threadBar = new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);
			
		add(panel);
		setTitle("키오스크 프로그램 로딩 중입니다.");
		setSize(500, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}