public class Rabbit extends Animal {
	public Rabbit (String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y);
		this.shape = "(o:3";
	}
	
	@Override
	public void move(int delta_x, int delta_y) {
		if (delta_x >3 || delta_x < -3) delta_x = 3;
		if (delta_y >3 || delta_y < -3) delta_y = 3;
		// 계속 겹치니까 상위클래스로 밀어줘도 됨. move limit 변수 하나 더 만들어서...
		
		super.move(delta_x, delta_y);
	}
}
