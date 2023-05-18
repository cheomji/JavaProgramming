import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	JMenuItem itemNew;
	JButton buttonLine = new JButton("Line");
	JButton buttonOval = new JButton("Oval");
	MyPanel p = new MyPanel();
	
	public MyFrame() {
		this.setTitle("paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(p, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		itemNew = new JMenuItem("New");
		fileMenu.add(itemNew);
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2, 1));
		jPanel.add(buttonLine);
		jPanel.add(buttonOval);
		contentPane.add(jPanel, BorderLayout.EAST);
		
		myActionListener myact = new myActionListener();
		itemNew.addActionListener(myact);
		buttonLine.addActionListener(myact);
		buttonOval.addActionListener(myact);
		
		
		
		this.setVisible(true);
	}
	
	class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == itemNew) {
				p.lines.clear();
				p.ovals.clear();
				repaint();
			}
			else if (e.getSource() == buttonLine) {
				System.out.println("line pressed");
				p.type = true;
			}
			else if (e.getSource() == buttonOval) {
				System.out.println("oval pressed");
				p.type = false;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}
