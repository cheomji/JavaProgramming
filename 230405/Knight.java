
public class Knight extends Player implements Comparable<Knight>{

	public Knight(String name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sound() {
		System.out.println("i'm fucking horse");
	}

	@Override
	public void show() {
		System.out.println("Knight");
	}

	@Override
	public int compareTo(Knight o) {
		if (this.money < o.money) return -1;
		if (this.money > o.money) return 1;
		return 0;
		// return this.money - o.money;
	}

}
