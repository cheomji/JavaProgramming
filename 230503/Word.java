import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Word implements Comparable<Word> {
	public String word;
	public int count;
	
	public Word(String word) {
		this.word = word;
		this.count = 1;
	}
	
	public static ArrayList<Word> findWordFrequencyInDescendingOrder(String paragraph){
		ArrayList<Word> list = new ArrayList<Word>();
		String[] tmp = paragraph.split(" ");
		HashMap<String,Integer> wordset = new HashMap<String,Integer>();
		for(String word : tmp) {
			Integer count = wordset.get(word);
			if (count != null) wordset.put(word, count+1);
			else wordset.put(word, 1);
		}
		for (String key : wordset.keySet()) {
			Word w = new Word(key);
			w.count = wordset.get(key);
			list.add(w);
		}
		Collections.sort(list);
		return list;
	}
	
	@Override
	public String toString() {
		return "(" + this.word + "," + this.count + ")";
	}

	@Override
	public int compareTo(Word o) {
		return o.count - this.count;
	}
}
