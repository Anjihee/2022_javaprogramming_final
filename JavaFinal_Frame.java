import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JavaFinal_Frame extends JFrame {
	public JavaFinal_Frame() {
		setTitle("키오스크 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JavaFinal());
		setSize(1150,800);
		setVisible(true);
	}
}
