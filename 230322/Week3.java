
public class Week3 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(3,2);
		Rectangle r2 = new Rectangle(4, 10);
		Triangle t1 = new Triangle(3, 2);
		Rectangle r3 = new Rectangle(3);
		
		System.out.println("the area of r1 : "+ r1.getArea());
		r1.show();
		
		System.out.println("");
		
		System.out.println("the area of r2 : "+ r2.getArea());
		r2.show();
		r2.roll(1);
		r2.show();
		
		System.out.println("");
		
		t1.show();
		System.out.println("이거교수님코드그대로햇다가잘못햇는ㄷ ㅔi 변수문제엿\n");
		
		System.out.println("compare r1 and r2 >> " + r1.compare(r2));
		
		System.out.println("compare r1 and t1 >> " + r1.compare(t1));
		
		System.out.println("compare t1 and r1 >> " + t1.compare(r1));
		
		r3.show();
		
	}

}
