import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	Line currentLine = null;
	Oval currentOval = null;
	Vector<Line> lines = new Vector<Line>();
	Vector<Oval> ovals = new Vector<Oval>();
	Boolean type = true; // line == true, oval == false
	
	public MyPanel() {
		this.setBackground(Color.white);
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml);
		this.addMouseMotionListener(ml);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (currentLine != null) 
			g.drawLine(currentLine.x1, currentLine.y1, currentLine.x2, currentLine.y2);
		else if (currentOval != null)
			g.drawOval(Math.min(currentOval.x1, currentOval.x2), Math.min(currentOval.y1, currentOval.y2), Math.abs(currentOval.x1-currentOval.x2), Math.abs(currentOval.y1-currentOval.y2));
		
		for (Line l : lines) 
			g.drawLine(l.x1, l.y1, l.x2, l.y2);
		for (Oval o : ovals) 
			g.drawOval(Math.min(o.x1, o.x2), Math.min(o.y1, o.y2), Math.abs(o.x1-o.x2), Math.abs(o.y1-o.y2));
		
	}
	
	class Line {
		public int x1, x2, y1, y2;
	}
	class Oval {
		public int x1, x2, y1, y2;
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (MyPanel.this.type == true) {
				currentLine = new Line();
				currentLine.x1 = e.getX();
				currentLine.y1 = e.getY();
			}
			else {
				currentOval = new Oval();
				currentOval.x1 = e.getX();
				currentOval.y1 = e.getY();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (MyPanel.this.type == true) {
				lines.add(currentLine);
				currentLine = null;
			}
			else {
				ovals.add(currentOval);
				currentOval = null;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if (MyPanel.this.type == true) {
				currentLine.x2 = e.getX();
				currentLine.y2 = e.getY();
				repaint();
			}
			else {
				currentOval.x2 = e.getX();
				currentOval.y2 = e.getY();
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {}
		
	}
}
