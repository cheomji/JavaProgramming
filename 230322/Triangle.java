
public class Triangle {

	public int width;
	public int height;
	
	public Triangle(int w, int h) {
		width = w; height = h;
	}
	
	public double getArea() {
		return width*height/2;
	}
	
	public void show() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < (i+1)*width/height; j++) { // 변수 체크 잘 
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public double compare(Triangle ti) {
		return this.getArea() - ti.getArea();
	}
	
	public double compare(Rectangle ri) {
		return this.getArea() - ri.getArea();
	}
}
