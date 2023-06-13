import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SharedBufferFrame extends JFrame {
	SharedBuffer sharedBuffer;
	public SharedBufferFrame() {
		this.setTitle("wait() & notify() ����ϴ� ���� ���� ��");// ���� ��� ����
		// Frame�� ���� ��� ���α׷��� �����ϵ��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);// Frame�� ���μ��� �ȼ� �� ����

		// content pane ��ü ������
		Container contentPane = this.getContentPane();
		// layout manager ����
		contentPane.setLayout(null);

		this.sharedBuffer = new SharedBuffer(100);
		this.sharedBuffer.setBackground(Color.WHITE);		
		this.sharedBuffer.setOpaque(true);
		this.sharedBuffer.setLocation(20, 200);
		this.sharedBuffer.setSize(450, 50);
		contentPane.add(this.sharedBuffer);
		
		this.setVisible(true);// Frame�� ���̵��� ��
		contentPane.addKeyListener(new BufferKeyListener());
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		
		Thread bufferThread = new Thread(new BufferRunnable());
		bufferThread.start();
	}
	
	class BufferRunnable implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					return;
				}
				SharedBufferFrame.this.sharedBuffer.consume();
			}
		}
	}
	
	class BufferKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) SharedBufferFrame.this.sharedBuffer.produce();			
		}

		@Override
		public void keyReleased(KeyEvent e) {}		
	}
	
	public static void main(String[] args) {
		SharedBufferFrame f = new SharedBufferFrame();
	}
}
