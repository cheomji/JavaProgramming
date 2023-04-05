import java.util.Arrays;

public class Week5 {

	public static void main(String[] args) {
//		Player p1 = new Player("Rook", 0, 0);
//		Player p2 = new Player("Knight", 0, 0);
//		Player p3 = new Player("Queen", 0, 0);
//		
//		p1.borrow(100000); p2.borrow(50000); p3.borrow(30000);
//		Player.increase_total_money(1000000);
//		System.out.println(p1.money + ", " + Player.get_total_money());
//		System.out.println(p2.money + ", " + Player.get_total_money());
//		System.out.println(p3.money + ", " + Player.get_total_money());
		
		
//		Knight k = new Knight("K", 0, 0);
//		Rook r = new Rook("r", 0,0);
//		Queen q = new Queen("q", 0, 0);
//		
//		k.borrow(1000);
//		r.borrow(2000);
//		
//		System.out.println(k.money + "," + Knight.get_total_money());
//		System.out.println(r.money + "," + Rook.get_total_money());
		
		
		Knight k1 = new Knight("k1", 1, 1); k1.borrow(1000);
		Knight k2 = new Knight("k2", 2, 2); k2.borrow(200);
		Knight k3 = new Knight("k3", 3, 3); k3.borrow(300);
		
		Knight kArray[] = {k1, k2, k3};
		Arrays.sort(kArray);
		for (Knight k : kArray)
			System.out.println(k.name + "," + k.money);
		
		Queen q1 = new Queen("q1", 1, 1); q1.borrow(100);
		Queen q2 = new Queen("q2", 2, 2); q2.borrow(10);
		Queen q3 = new Queen("q3", 3, 3); q3.borrow(1000);
		
		Queen qArray[] = {q1, q2, q3};
		Arrays.sort(qArray);
		for (Queen q : qArray)
			System.out.println(q.name + "," + q.money);

	}
}
