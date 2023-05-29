
public class SharedDoc {
	public String text;
	
	public SharedDoc() {
		this.text = "";
	}
	
	synchronized public void addText(String text, int number) {
		int myTextLen = this.text.length() - (this.text.length()/50);
		// except "\n"
		for (int i = 0; i < number; i++) {
			int check = 50 - (myTextLen % 50);
			
			if (0 < check && check <= text.length()) {
				int j = 0;
				for (; j < check; j++) {
					this.text += text.charAt(j);
				}
				this.text += System.lineSeparator();
				for (; j < text.length(); j++) {
					this.text += text.charAt(j);
				}
			}
			else {
				this.text += text;
			}
			myTextLen += text.length();
		}
	}
	
}
