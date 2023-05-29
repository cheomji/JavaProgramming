
public class SharedDoc {
	public String text;
	
	public SharedDoc() {
		this.text = "";
	}
	// 굳이 이렇게 할 필요 없이 이중포문 돌리면 됏음.. 12주차 수업자료 46페이지에 그대로 나와 잇음ㅇㅇ
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
