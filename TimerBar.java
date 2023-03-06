import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//TimerBar
public class TimerBar extends JLabel implements Runnable {
	//Ÿ�ӹ� ũ�� ����
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

	//������ ����
	@Override
	public void run() {
		while (true) {
			try { //�ð� ����
				Thread.sleep(800 / (width / second));
			} catch (Exception e) {
				e.printStackTrace();
			}

			//�ð��� ���� �ʺ� �پ���.
			if (getWidth() > 0) {
				width -= 1;	// �ʺ� 1�� �پ��
				//System.out.println(width);
				setBounds(x, y, width, height);
			} else {
				//System.out.println("����");
				break;
			}
		}
	}
}

