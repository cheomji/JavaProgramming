import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	JTextArea textArea = new JTextArea();
	JRadioButton buttonBlack = new JRadioButton("Black");
	JRadioButton buttonBlue = new JRadioButton("Blue");
	JRadioButton buttonGreen = new JRadioButton("Green");
	JComboBox<Integer> comboBox;
	JMenuItem itemSave;
	
	public MyFrame() {
		this.setTitle("test editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane sPane = new JScrollPane(textArea);
		contentPane.add(sPane, BorderLayout.CENTER);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(4, 1));
		contentPane.add(jPanel, BorderLayout.EAST);
		
		jPanel.add(this.buttonBlack);
		jPanel.add(this.buttonBlue);
		jPanel.add(this.buttonGreen);
		
		ButtonGroup group = new ButtonGroup();
		group.add(buttonBlack);
		group.add(buttonBlue);
		group.add(buttonGreen);
		buttonBlack.setSelected(true);
		buttonBlack.setForeground(Color.black);
		buttonBlue.setForeground(Color.blue);
		buttonGreen.setForeground(Color.green);
		
		Integer fontSize[] = {20, 30, 50, 100};
		comboBox = new JComboBox<Integer>(fontSize);
		jPanel.add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		itemSave = new JMenuItem("Save");
		fileMenu.add(itemSave);
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		
		myActionListener acl = new myActionListener();
		buttonBlack.addActionListener(acl);
		buttonBlue.addActionListener(acl);
		buttonGreen.addActionListener(acl);
		comboBox.addActionListener(acl);
		itemSave.addActionListener(acl);
		
		this.setVisible(true);
	}
	
	class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonBlack)
				textArea.setForeground(Color.black);
			else if(e.getSource() == buttonBlue)
				textArea.setForeground(Color.blue);
			else if(e.getSource() == buttonGreen)
				textArea.setForeground(Color.green);
			else if(e.getSource() == comboBox)
				textArea.setFont(new Font("함초롬돋움", Font.PLAIN, (int) comboBox.getSelectedItem()));
			else if(e.getSource() == itemSave)
				System.out.println(JOptionPane.showInputDialog("type a name for the file"));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}
