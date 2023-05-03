import java.util.*;

public class Week9 {	
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("ditto");
		set.add("ditto");
		set.add("dffffff");
		
		System.out.println(set.contains("ditto"));
		System.out.println(set.contains("omg"));
		System.out.println(set.size());
		
	}
}
