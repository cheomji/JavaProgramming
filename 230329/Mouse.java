public class Mouse extends Animal {
	public Mouse(String name, int age, double weight, int x, int y) {
		super(name, age, weight, x, y);
		this.shape = "ᘛ⁐̤ᕐᐷ";
	}
	
	@Override
	public void move(int delta_x, int delta_y) {
		if (delta_x >1 || delta_x < -1) delta_x = 1;
		if (delta_y >1 || delta_y < -1) delta_y = 1;
		
		//this.x += delta_x; 
		//this.y += delta_y;
		super.move(delta_x, delta_y);
	}
}
