public class LList<T> {
	T current;
	LList<T> next;
	
	public LList(T object) {
		current = object;
		next = null;
	}
	
	public void insert(T object) {
		if (next == null) next = new LList<T>(object);
		else {
			LList<T> tmp = next;
			next = new LList<T>(object);
			next.next = tmp;
		}
	}
	
	public void printAll() {
		LList<T> node = this;
		while (node!=null) {
			System.out.print(node.current + " ");
			node = node.next;
		}		
		System.out.println("");
	}
	
	public LList<T> search(T object) {
		LList<T> node = this;
		while (node!=null) {
			if (node.current.equals(object)) return node;
			node = node.next;
		}
		return null;
	}
}
