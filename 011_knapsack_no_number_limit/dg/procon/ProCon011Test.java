package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class ProCon011Test {
	@Test
	public void test1() throws Exception {
		runTest(
				3,
				new int[]{3, 4, 2},
				new int[]{4, 5, 3},
				7,
				"10");
	}
	
	@Test
	public void test2() throws Exception {
		runTest(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				10,
				"20");
	}
	
	@Test
	public void test3() throws Exception {
		runTest(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				8,
				"16");
	}
	
	@Test
	public void test4() throws Exception {
		runTest(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				2,
				"4");
	}
	
	public void runTest(int n, int[] w, int[] v, int W, String expected) throws Exception {
		// 初期化
		setInit(n, w, v, W);

		Method method = ProCon011.class.getDeclaredMethod("run");
		// privateメソッドの使用を許可
		method.setAccessible(true);

		// メソッドの実行（必要な引数を設定）
		Integer actual = (Integer)method.invoke(new ProCon010());
		// 実行結果の検証
		assertThat(actual.toString(), is(expected));
	}
	
	private void setInit(int n, int[] w, int[] v, int W) {
		ProCon011.n = n;
		ProCon011.w = w;
		ProCon011.v = v;
		ProCon011.W = W;
	}
}
