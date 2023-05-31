import javax.swing.JFrame;

public class GameFrame extends JFrame {

	public GameFrame() {
		this.setTitle("Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setContentPane(new GamePanel());
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame gf = new GameFrame();
	}

}
