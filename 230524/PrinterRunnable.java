
public class PrinterRunnable implements Runnable {
	SharedPrinter sp;
	String text;
	int number;
	
	public PrinterRunnable(SharedPrinter printer, String text, int number) {
		this.sp = printer;
		this.text = text;
		this.number = number;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		sp.print(text, number);
	}

}
