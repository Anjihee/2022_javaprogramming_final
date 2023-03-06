import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class JavaFinal extends JPanel {

	JButton[] MenuButton = new JButton[8];

	ImageIcon[] images = { // ImageIcon 클래스 객체 images를 배열로 선언합니다.
		new ImageIcon("images/img1.jpg"),
		new ImageIcon("images/img2.jpg"), // [1]
        new ImageIcon("images/img3.jpg"), // [2]
        new ImageIcon("images/img4.jpg"), // [0]
        new ImageIcon("images/img5.jpg"), // [1]
        new ImageIcon("images/img6.jpg"), // [2]
        new ImageIcon("images/img7.jpg"), // [0]
        new ImageIcon("images/img8.jpg"), // [1]
	};

	String[] menu = {
			"김치 필라프","새우 필라프", "토마토 파스타","까르보나라",
			"알리오 올리오","냉모밀","카레밥","카레 우동"};

	int[] price = {
			6000,6000,7000,7000,
			6500,6500,4500,6500,
			3500,2500,3500};

			
	JTextField tf = new JTextField(30);
	JButton[] Service = new JButton[3];
	String[] BtString = {"선택취소","전체취소","결제"};
	String [] ColName = {"메뉴","수량","가격"};
	String [][] Data ;
	int count =1;

	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	ImageIcon image1 = new ImageIcon("images/title.jpg"); //이미지경로
	JLabel label = new JLabel(image1);
	
	//선택된 음식 나오는 테이블
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.WHITE);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("굴림", Font.BOLD, 15));
			table.setBackground(new Color(201, 231, 248));
			add(new JScrollPane(table));
		}
	}
	//음식 버튼
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(6,3,3,3));
			setBackground(Color.WHITE);
			for(int i=0;i<MenuButton.length;i++) {
				MenuButton[i]= new JButton(images[i]);
				MenuButton[i].setBackground(Color.WHITE);
				add(MenuButton[i]);
			}
		}
	}
	
	//서비스 버튼
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(Color.WHITE);
			setLayout(new GridLayout(1,4,3,3));
			
			for(int i=0;i<BtString.length;i++) {
				Service[i]= new JButton(BtString[i]);
				Service[i].setBackground(new Color(201, 231, 248));
				add(Service[i]);
			}
		}
	}

	//총금액 출력
	class LabelText extends JPanel{
		LabelText(){
			setBackground(Color.WHITE);
			add(label);
		}
	}
	
	public JavaFinal() {
		
		setLayout(null);
		setBackground(Color.WHITE);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		LabelText lt = new LabelText();

		//금액란
		sbtn.setSize(550, 100);
		sbtn.setLocation(25, 575);
		add(sbtn);
		
		mbtn.setSize(550, 530);
		mbtn.setLocation(25, 105);
		add(mbtn);
		
		sc.setSize(550, 460);
		sc.setLocation(600, 100);
		add(sc);
		
		tf.setSize(450, 100);
		tf.setLocation(650, 575);
		add(tf);

		lt.setSize(400, 100);
		lt.setLocation(400 , 0);
		add(lt);
		

		//메뉴추가
		for(int i=0;i<MenuButton.length;i++) {
			final int index =i;
			MenuButton[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MenuButton = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{menu[index],count,price[index]});
				}
			});
		}
	
	    //선택취소
		Service[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());
			}
		});
	
		
		//전체취소
		Service[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});

		//결제버튼
		Service[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum =0;
				for(int i=0;i<rowCont;i++) {
					sum += (int)table.getValueAt(i, 2);
				}
				tf.setText(String.valueOf(" 총 금액 : "+sum));
				tf.setFont(new Font("굴림", Font.BOLD, 40));
			}
		});
	}
}
