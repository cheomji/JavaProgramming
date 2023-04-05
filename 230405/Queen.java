
public class Queen extends Player implements Comparable<Queen> {

	public Queen(String name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sound() {
		System.out.println("OK");
	}
	
	@Override
	public void show() {
		System.out.println("Queen");
	}

	@Override
	public int compareTo(Queen o) {
		return (this.x != o.x) ? this.x - o.x: this.y-o.y;
	}

}
