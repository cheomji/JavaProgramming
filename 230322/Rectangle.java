
public class Rectangle {
	
	public int width;
	public int height;
	
	public Rectangle(int width) {
		this.width = width;
		this.height = width;
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		return width*height;
	}
	
	public void show() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				System.out.print("*");
			System.out.println("");
		}
	}
	
	public void roll(int n) {
		if (n%2 == 1) {
			int tmp = width;
			width = height;
			height = tmp;
		}
	}
	
	public int compare(Rectangle ri) {
		return this.getArea() - ri.getArea();
	}
	
	public double compare(Triangle ti) {
		return this.getArea() - ti.getArea();
	}
	
	public void sample(Rectangle ri) {
		Rectangle copy = new Rectangle(ri.width, ri.height);
	}

}
