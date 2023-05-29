
public class DocRunnable implements Runnable {
	public SharedDoc doc;
	public String text;
	public int number;
	
	public DocRunnable(SharedDoc doc, String text, int number) {
		this.doc = doc;
		this.text = text;
		this.number = number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		doc.addText(this.text, this.number);
	}

}
