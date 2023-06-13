import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

public class SharedBuffer extends JLabel {
	int maxBufferSize, currentBufferSize;
	public SharedBuffer(int maxBufferSize) {
		this.maxBufferSize = maxBufferSize;
		this.currentBufferSize = 0;
	}
	
	synchronized void produce() {
		while (this.currentBufferSize >= this.maxBufferSize) {
			try {
				System.out.println("produce() begins to wait");
				this.wait();
				System.out.println("produce() wakes up");
			} catch (InterruptedException e) {				
				return;
			}
		}
		
		this.currentBufferSize++; 
		repaint();
		this.notify();
	}
	
	synchronized void consume() {		
		while (this.currentBufferSize <= 0) {
			try {
				System.out.println("consume() begins to wait");
				this.wait();
				System.out.println("consume() wakes up");
			} catch (InterruptedException e) {
				return;
			}
		}		
		
		this.currentBufferSize--;
		repaint();
		this.notify();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		int width = getWidth() * currentBufferSize / maxBufferSize;
		g.fillRect(0, 0, width, getHeight());
	}
}
