
public class Player extends GameObject {
	public Player(int x, int y) {
		super(x, y, "starship.png");
		this.dx = 0; this.dy = 0;
	}

	public void move() {
		this.x += this.dx; this.y += this.dy;
		
		if (this.x < 10) this.x = 10;
		if (this.x > 740) this.x = 740;
	}
}
