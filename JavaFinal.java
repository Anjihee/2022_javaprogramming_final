import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class JavaFinal extends JPanel {

	JButton[] MenuButton = new JButton[8];

	ImageIcon[] images = { // ImageIcon Ŭ���� ��ü images�� �迭�� �����մϴ�.
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
			"��ġ �ʶ���","���� �ʶ���", "�丶�� �Ľ�Ÿ","�������",
			"�˸��� �ø���","�ø��","ī����","ī�� �쵿"};

	int[] price = {
			6000,6000,7000,7000,
			6500,6500,4500,6500,
			3500,2500,3500};

			
	JTextField tf = new JTextField(30);
	JButton[] Service = new JButton[3];
	String[] BtString = {"�������","��ü���","����"};
	String [] ColName = {"�޴�","����","����"};
	String [][] Data ;
	int count =1;

	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	ImageIcon image1 = new ImageIcon("images/title.jpg"); //�̹������
	JLabel label = new JLabel(image1);
	
	//���õ� ���� ������ ���̺�
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.WHITE);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("����", Font.BOLD, 15));
			table.setBackground(new Color(201, 231, 248));
			add(new JScrollPane(table));
		}
	}
	//���� ��ư
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
	
	//���� ��ư
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

	//�ѱݾ� ���
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

		//�ݾ׶�
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
		

		//�޴��߰�
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
	
	    //�������
		Service[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());
			}
		});
	
		
		//��ü���
		Service[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});

		//������ư
		Service[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MenuButton = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum =0;
				for(int i=0;i<rowCont;i++) {
					sum += (int)table.getValueAt(i, 2);
				}
				tf.setText(String.valueOf(" �� �ݾ� : "+sum));
				tf.setFont(new Font("����", Font.BOLD, 40));
			}
		});
	}
}
