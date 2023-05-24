
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		int number = 1;
		while(true)
			System.out.println(Thread.currentThread().getName() + ", " + number++);
	}
}
