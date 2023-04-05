
public abstract class Player {
	private static int total_money = 1000000;
	public static int total_num_borrow = 0;
	
	String name;
	int money;
	int x,y;
	int score;
	
	public Player(String name, int x, int y) {
		this.name = name; this.x = x; this.y = y;
		this.money = 0; this.score = 0;
	}
	
	public static void increase_total_money(int money) {
		if (money >= 0) Player.total_money += money;
	}
	
	public static int get_total_money() {
		return Player.total_money;
	}
	
	public void move(int delta_x, int delta_y) {
		this.x += delta_x; this.y += delta_y;
	}
	
	public void borrow(int m) { // 은행에서 m원을 빌림
		if (total_money >= m) {	total_money -= m; this.money += m; 
		Player.total_num_borrow++; // 클래스 이름에다가 접금한면 가독성 높일 수 있
		}
	}
	
	public void repay(int m) { // 은행에 m원을 돌려줌
		if (this.money >= m) { this.money -= m;	total_money += m; }
	}
	
	public abstract void sound();
	
	public abstract void show();
}
