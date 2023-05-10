import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	JLabel label;
	
	public MyFrame() {
		this.setTitle("bomin의 GUI 프로그램");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		
		label = new JLabel("Move Me");
		label.setSize(150,40);
		label.setLocation(100, 100);
		panel.add(label);
		
		panel.addMouseListener(new MyMouseListener());
		panel.addMouseMotionListener(new MyMouseMotionListener());
		
		this.setVisible(true);
		
		panel.addKeyListener(new MyKeyListener());
		panel.setFocusable(true);
		panel.requestFocus();
		
	}
	
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			MyFrame.this.label.setText("Entered at (" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			MyFrame.this.label.setText("Exited at (" + e.getX() + "," + e.getY() + ")");
		}
		
	}
	
	class MyMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			MyFrame.this.label.setText("Dragged at (" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {}
		
	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) 
				MyFrame.this.label.setText("LEFT arrow key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}
