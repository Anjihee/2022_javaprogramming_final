import java.awt.*;
import javax.swing.*;

public class TimerBarFrame extends JFrame {
	JPanel panel;
	
	TimerBar timerBar;
	Thread threadBar;
	
	public TimerBarFrame() {
		int second = 2;		// ��
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerBar = new TimerBar(second);
		threadBar = new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);
			
		add(panel);
		setTitle("Ű����ũ ���α׷� �ε� ���Դϴ�.");
		setSize(500, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}