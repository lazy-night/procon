package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class ProCon012Test {

	@Test
	public void test01() {
		try {
			runTest(
					4,
					new int[]{2, 1, 3, 2},
					new int[]{3, 2, 4, 2},
					5,
					"7");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test02() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					10,
					"14");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test03() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					9,
					"13");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test04() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					8,
					"11");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test05() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					7,
					"11");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test06() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					6,
					"11");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test07() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					5,
					"9");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test08() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					4,
					"8");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test09() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					3,
					"6");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test10() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					2,
					"3");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test11() {
		try {
			runTest(
					5,
					new int[]{3, 4, 1, 2, 3},
					new int[]{2, 3, 2, 3, 6},
					1,
					"2");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void test12() {
		// No.012のテスト(最大値)
		int n      = 100;
		int[] w    = new int[n];
		int[] v    = new int[n];
		int W      = intPow(10, 9);
		String exp = "10000";
		
		for (int i = 0; i < n; i++) {
			w[i] = intPow(10, 7);
			v[i] = 100;
		}
		
		try {
			runTest(n, w, v, W, exp);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	public void runTest(int n, int[] w, int[] v, int W, String expected) throws Exception {
		// 初期化
		setInit(n, w, v, W);

		Method method = ProCon012.class.getDeclaredMethod("run");
		// privateメソッドの使用を許可
		method.setAccessible(true);

		// メソッドの実行（必要な引数を設定）
		Integer actual = (Integer)method.invoke(new ProCon012());
		// 実行結果の検証
		org.hamcrest.MatcherAssert.assertThat(actual.toString(), is(expected));
	}
	
	private void setInit(int n, int[] w, int[] v, int W) {
		ProCon012.n = n;
		ProCon012.w = w;
		ProCon012.v = v;
		ProCon012.W = W;
	}
	
	private int intPow(int radix, int index) {
		if (index == 1) return radix;
		return intPow(radix, index - 1) * radix;
	}
}
