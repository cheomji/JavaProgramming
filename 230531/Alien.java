
public class Alien extends GameObject {
	public static int speedX = 3;
	public static int speedY = 20;
	
	public Alien(int x, int y) {
		super(x, y, "alien.png");
		this.dx = -Alien.speedX; this.dy = Alien.speedY;
	}

	public void move() {
		this.x += this.dx; 
		
		if ((this.dx < 0 && this.x < 10) || (this.dx > 0 && this.x > 740)) {
			this.dx = -this.dx;
			this.y += this.dy;
		}		
	}
	
	public boolean isOutOfScreen() {
		if (this.y > 600) return true;
		else return false;
	}
}
