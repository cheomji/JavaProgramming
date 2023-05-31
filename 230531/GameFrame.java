import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;

public class GamePanel extends JPanel {
	Player player = new Player(370, 500);
	Vector<Bullet> bulletList = new Vector<Bullet>();
	Vector<Alien> alienList = new Vector<Alien>();
	Boolean done = false;
	Boolean isClear = false;
	static int score = 0;
	
	public GamePanel() {
		this.setBackground(Color.black); 
		
		this.addKeyListener(new PlayerKeyListener());
		this.setFocusable(true);
		this.requestFocus();
		
		Thread tplayer = new Thread(new PlayerRunnable());
		tplayer.start();
		
		Thread tbullet = new Thread(new BulletRunnable());
		tbullet.start();
		
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 12; x++) {
				Alien alien = new Alien(x * 50 + 100, y * 30 + 100);
				alienList.add(alien);
			}
		}
		
		Thread talien = new Thread(new AlienRunnable());
		talien.start();
	}
	
	class PlayerRunnable implements Runnable{

		@Override
		public void run() {
			while (true) {
				if (done == false) {
					player.move();
					repaint();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class BulletRunnable implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (done == false && isClear == false) {
					synchronized (GamePanel.this) {
						Iterator<Bullet> iterBullet = bulletList.iterator();
						while (iterBullet.hasNext()) {
							Bullet bullet = iterBullet.next();
							bullet.move();
							if (bullet.isOutOfScreen()) iterBullet.remove();
							else {
								// 외계인이랑 충돌하면 외계인+총알 삭제
								Iterator<Alien> iterAlien = alienList.iterator();
								while(iterAlien.hasNext()) {
									Alien alien = iterAlien.next();
									if (bullet.collideWith(alien)) {
										iterAlien.remove();
										iterBullet.remove();
										score += 100;
										if (alienList.size() == 0)
											isClear = true;
										break;
									}
								}
							}
						}
					}
					repaint();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class AlienRunnable implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (done == false && isClear == false) {
					synchronized (GamePanel.this) {
						Iterator<Alien> iterAlien = alienList.iterator();
						while (iterAlien.hasNext()) {
							Alien alien = iterAlien.next();
							alien.move();
							if (alien.isOutOfScreen()) iterAlien.remove();
							else {
								// player 이랑 충돌하면 game over 출력
								if (alien.collideWith(player)) {
									done = true;
								}
							}
						}
					}
					repaint();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class PlayerKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.dx = -3;
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.dx = 3;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (player.dx == -3)
					player.dx = 0;
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (player.dx == 3)
					player.dx = 0;
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Bullet bullet = new Bullet(player.x+10, player.y-30);
				synchronized (GamePanel.this) {
					bulletList.add(bullet);
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(player.image, player.x, player.y, null);
		
		synchronized (GamePanel.this) {
			for (Bullet b : bulletList) {
				g.drawImage(b.image, b.x, b.y, null);
			}
			for (Alien a : alienList) {
				g.drawImage(a.image, a.x, a.y, null);
			}
		}
		
		if (done == true) {
			g.setFont(new Font("Arial", Font.BOLD, 100));
			g.setColor(Color.white);
			g.drawString("Game Over", 110, 250);
		}
		
		if (isClear == true) {
			g.setFont(new Font("Arial", Font.BOLD, 100));
			g.setColor(Color.white);
			g.drawString("You win", 110, 250);
		}
		
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.setColor(Color.white);
		g.drawString("Score:"+score, 670, 20);
	}
}
