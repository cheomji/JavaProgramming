
public class C implements I1, I2 {
	public static int f1_cnt = 0;
	public static int f2_cnt = 0;

	@Override
	public int f2() {
		C.f2_cnt++;
		return C.f1_cnt;
	}

	@Override
	public int f1() {
		C.f1_cnt++;
		return C.f2_cnt;
	}

}
