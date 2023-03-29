
public class Week4 {

	public static void main(String[] args) {
		Bear b = new Bear("fxxkingbear", 24, 70.0, -1, 2);
		Mouse m = new Mouse("집가고싶다", 3, 2.0, -2, -2);
		
		b.showInfo();
		b.show();
		m.showInfo();
		m.show();
		
		System.out.println(m.distFrom(b));
		System.out.println(b.distFrom(m));
		
		System.out.println(b.agediff(m));
		
		m.move(100, 100);
		m.showInfo();
		
		b.move(100, 100);
		b.showInfo();
	}

}
