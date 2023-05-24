import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MyFrame extends JFrame {
	static int playerMove = 10;
	static int monsterMove = 5;
	static int monsterDelay = 200;	
	
	JLabel playerLabel = new JLabel("@");
	JLabel[] monsterLabel = new JLabel[3];
	
	public MyFrame() {
		this.setTitle("�ƹ�Ÿ ���� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,700);
		
		Random randGen = new Random();
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		this.playerLabel.setForeground(Color.red);
		this.playerLabel.setSize(15, 15);		
		this.playerLabel.setLocation(randGen.nextInt(this.getWidth()), randGen.nextInt(this.getHeight()));
		contentPane.add(this.playerLabel);
		
		for (int i = 0; i < monsterLabel.length; i++) {
			monsterLabel[i] = new JLabel("M");
			monsterLabel[i].setForeground(Color.blue);
			monsterLabel[i].setSize(15, 15);			
			monsterLabel[i].setLocation(randGen.nextInt(this.getWidth()), randGen.nextInt(this.getHeight()));
			contentPane.add(monsterLabel[i]);
			
			Thread t = new Thread(new MonsterRunnable(i));
			t.start();
		}
		
		this.setVisible(true);
		
		contentPane.addKeyListener(new PlayerKeyListener());
		contentPane.setFocusable(true);
		contentPane.requestFocus();
	}
	
	class MonsterRunnable implements Runnable {
		int monsterID;
		public MonsterRunnable (int monsterID) {
			this.monsterID = monsterID;
		}
		
		@Override
		public void run() {
			while(true) {
				//System.out.println("moving monster " + this.monsterID);
				int deltaX = playerLabel.getX() - monsterLabel[this.monsterID].getX();
				if (deltaX > monsterMove) deltaX = monsterMove;
				if (deltaX < -monsterMove) deltaX = -monsterMove;
				int deltaY = playerLabel.getY() - monsterLabel[this.monsterID].getY();
				if (deltaY > monsterMove) deltaY = monsterMove;
				if (deltaY < -monsterMove) deltaY = -monsterMove;
				moveLabel(monsterLabel[this.monsterID], deltaX, deltaY);				
				repaint();
				
				try {
					Thread.sleep(monsterDelay);
				} catch (InterruptedException e) {
					return;
				}
			}
		}		
	}
	
	class PlayerKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP: moveLabel(playerLabel, 0, -playerMove); break;
			case KeyEvent.VK_DOWN: moveLabel(playerLabel, 0, playerMove); break;
			case KeyEvent.VK_LEFT: moveLabel(playerLabel, -playerMove, 0); break;
			case KeyEvent.VK_RIGHT: moveLabel(playerLabel, playerMove, 0); break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}		
	}
	
	void moveLabel(JLabel label, int deltaX, int deltaY) {		
		int newX = label.getX() + deltaX;
		newX = newX < 0 ? 0: newX > this.getWidth() - label.getWidth() ? this.getWidth() - label.getWidth(): newX;
		
		int newY = label.getY() + deltaY;
		newY = newY < 0 ? 0: newY > this.getHeight() - label.getHeight() ? this.getHeight() - label.getHeight() : newY;
				
		label.setLocation(newX, newY);		
		repaint();
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}
