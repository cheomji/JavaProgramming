
public class Rook extends Player implements Comparable <Rook>{

	public Rook(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	public void sound() {
		System.out.println("OK~");
	}
	
	@Override
	public void show() {
		System.out.println("rook");
	}

	@Override
	public int compareTo(Rook o) {
		return (this.score == o.score) ? this.money - o.money: this.score - o.score;
	}

}
