
public class Square {
	public int length;
	public int x;
	public int y;
	
	public Square(int length, int x, int y) {
		this.length = length;
		this.x = x;
		this.y = y;
	}
	
	public Square() {
		this.length = 1;
		this.x = 0;
		this.y = 0;
	}
	
	public int getArea() {
		return this.length * this.length;
	}
	
	public void move(int delta_x, int delta_y) {
		this.x += delta_x;
		this.y += delta_y;
	}
	
	
	public void move(int delta) {
		this.x += delta;
		this.y += delta;
	}
	
	public boolean increase(int delta) {
		if (this.length + delta < 0) return false;
		this.length += delta;
		return true;
	}
	
	public void exchange(Square s) {
		Square tmp = new Square();
		
		tmp.length = this.length;
		tmp.x = this.x;
		tmp.y = this.y;
		
		this.length = s.length;
		this.x = s.x;
		this.y = s.y;
		
		s.length = tmp.length;
		s.x = tmp.x;
		s.y = tmp.y;
    
    // this는 객체가 아니라 그냥 상수같은 거임. 그냥 단순히 swap하면 안됨. 근데 그게 이 클래스 밖에서는 먹힘.
	}
	
	public Square duplicate() {
		Square copy = new Square(this.length, this.x, this.y);
		return copy;
	}
}
