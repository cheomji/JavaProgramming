public class SharedPrinter {
	int numPrinted = 0;

	synchronized void print(String text, int number) {		
		for(int i = 0; i<number; i++) {
			for(int j = 0; j<text.length(); j++) {
				System.out.print(text.charAt(j));
				this.numPrinted++;
				if (this.numPrinted % 50 == 0) System.out.println();
			}
		}
		System.out.println();		
	}
}
