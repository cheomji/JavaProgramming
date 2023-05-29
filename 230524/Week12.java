// 과제 테스트용 메인함수
public class Week12 {

	public static void main(String[] args) {
		SharedDoc doc = new SharedDoc();
		Thread t1 = new Thread(new DocRunnable(doc, "aaa", 10));
		Thread t2 = new Thread(new DocRunnable(doc, "bbb", 100));
		Thread t3 = new Thread(new DocRunnable(doc, "ccc", 100));
		t1.start(); t2.start(); t3.start();
		try {
			t1.join(); t2.join(); t3.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(doc.text);
	}

}
