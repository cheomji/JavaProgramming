import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	JButton button1;
	
	public MyFrame() {
		this.setTitle("My first GUI program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		// 외형 결정 코드는 setVisible 앞쪽에 넣기 (뒤에 넣으면 안 보임)
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		contentPane.addMouseListener(new MyMouseListener());
		
		
		button1 = new JButton("1번 버튼");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.pink);
		button1.setOpaque(true);
		button1.setSize(100,40);
		button1.setLocation(60, 60);
		
		JLabel label1 = new JLabel("1번 라벨");
		label1.setBackground(Color.CYAN);
		label1.setForeground(Color.BLACK);
		label1.setOpaque(true);
		label1.setSize(100,40);
		label1.setLocation(80, 80);
		
		contentPane.add(button1, BorderLayout.NORTH);
		contentPane.add(label1, BorderLayout.SOUTH);
		
		JButton button2 = new JButton("2번 버튼");
		//JLabel label2 = new JLabel("2번 라벨");
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.CENTER);
		panel1.setBackground(Color.RED);
		panel1.setLayout(new GridLayout(3,3));
		panel1.add(new JButton("1"));
		panel1.add(new JButton("2"));
		panel1.add(new JButton("3"));
		panel1.add(new JButton("4"));
		panel1.add(new JButton("5"));
		panel1.add(new JButton("6"));
		panel1.add(new JButton("7"));
		panel1.add(new JButton("8"));
		panel1.add(new JButton("9"));
		
		
		contentPane.add(button2, BorderLayout.EAST);
		
		contentPane.add(new JButton("333"), BorderLayout.WEST);
		
		// setVisible
		this.setVisible(true);
		

		contentPane.addKeyListener(new MyKeyListener());
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}
	// inner class
	
	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == 'q') System.exit(0);
			else if (e.getKeyCode() == KeyEvent.VK_UP) {
				MyFrame.this.button1.setLocation(MyFrame.this.button1.getX(), MyFrame.this.button1.getY()-10);
				//button1.setLocation(button1.getX(), button1.getY()-10);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}
	
	class MyMouseListener implements MouseListener{
		
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			MyFrame.this.setTitle("mouse pressed" + e.getX() + "," + e.getY());
			MyFrame.this.button1.setLocation(e.getX(), e.getY());
			
			Container contentPane = MyFrame.this.getContentPane();
			contentPane.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			MyFrame.this.setTitle("mouse released" + e.getX() + "," + e.getY());
			MyFrame.this.button1.setLocation(e.getX(), e.getY());
			
			Container contentPane = MyFrame.this.getContentPane();
			contentPane.setBackground(Color.DARK_GRAY);
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

	

}
