package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon005Test {
	private StandardOutputSnatcher out = new StandardOutputSnatcher();
	private StandardInputSnatcher in = new StandardInputSnatcher();

	@Before
	public void before() {
		System.setOut(out);
		System.setIn(in);
	}

	@After
	public void after() {
		System.setOut(null);
		System.setIn(null);
	}

	@Test
	public void proCon005_main_method() {
		// 入力設定値
		setInit(
				5,								// n
				new int[]{1, 2, 4, 6, 8},		// s[]
				new int[]{3, 5, 7, 9, 10}		// t[]
				);
		
		// 予想値
		String expected = "count = 3";

		// テスト対象の実行
		ProCon005.main(new String[]{});

		// 出力は改行ごとに取得される(今回は一行のみ)
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	public static void setInit(int n, int[] s, int[] t) {
		ProCon005.n = n;
		ProCon005.s = s;
		ProCon005.t = t;
	}
}
