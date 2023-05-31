
public class Bullet extends GameObject {
	public static int speedY = 3;
	
	public Bullet(int x, int y) {
		super(x, y, "fire.png");
		this.dx = 0; this.dy = -Bullet.speedY;
	}

	public void move() {
		this.x += this.dx; this.y += this.dy;
	}
	
	public boolean isOutOfScreen() {
		if (this.y < 10) return true;
		else return false;
	}
}
