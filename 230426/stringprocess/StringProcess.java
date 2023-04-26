package stringprocess;

public class StringProcessor {
	
	public String extract_from_within_brackets(String str) {
		int front = str.indexOf('{');
		int rear = str.indexOf('}', front+1);
		if (front < 0 || rear < 0) return "";
		return str.substring(front+1, rear);
	}
	
	public String[] split_based_on_comma(String str) {
		return str.split(",");
	}
	
	public int count_as(String[] s) {
		int cnt = 0;
		for (String k : s) 
			if (k.startsWith("a")) cnt++;
		return cnt;
	}
}
