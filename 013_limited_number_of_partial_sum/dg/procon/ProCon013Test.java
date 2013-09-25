package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class ProCon013Test {
	@Test
	public void test1() throws Exception {
		runTest(
				3,
				new int[]{3, 5, 8},
				new int[]{3, 2, 2},
				17,
				"Yes");
	}
	
	@Test
	public void test2() throws Exception {
		runTest(
				3,
				new int[]{3, 5, 8},
				new int[]{3, 2, 2},
				1,
				"No");
	}
	
	@Test
	public void test3() throws Exception {
		runTest(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				44,
				"Yes");
	}
	
	@Test
	public void test4() throws Exception {
		int[] a = new int[100];
		int[] m = new int[100];
		
		for (int i = 0; i < 100; i++) {
			a[i] = i;
			m[i] = 100000 - 1;
		}
		//a[99] = 100000;
		
		runTest(
				100,
				a,
				m,
				100000,
				"Yes");
	}
	
	public void runTest(int n, int[] w, int[] v, int W, String expected) throws Exception {
		// 初期化
		setInit(n, w, v, W);

		Method method = ProCon013.class.getDeclaredMethod("run");
		// privateメソッドの使用を許可
		method.setAccessible(true);

		// メソッドの実行（必要な引数を設定）
		String actual = (String)method.invoke(new ProCon013());
		// 実行結果の検証
		assertThat(actual, is(expected));
	}
	
	private void setInit(int n, int[] a, int[] m, int K) {
		ProCon013.n = n;
		ProCon013.a = a;
		ProCon013.m = m;
		ProCon013.K = K;
	}
}
