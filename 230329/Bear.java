
public class Bear extends Animal {
	
	public Bear(String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y); // 이거 지우면 animal class에 인자 없는 생성자가 있지 않은 이상 에러뜸. 
		this.shape = "ʕ •ᴥ•ʔ";
		}
	
	@Override
	public void move(int delta_x, int delta_y) {
		if (delta_x >5 || delta_x < -5) delta_x = 5;
		if (delta_y >5 || delta_y < -5) delta_y = 5;
		
		super.move(delta_x, delta_y);
	}
}
