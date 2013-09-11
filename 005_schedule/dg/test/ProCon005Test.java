package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon005Test {
	private StandardOutputSnatcher out = new StandardOutputSnatcher();
	private StandardInputSnatcher in   = new StandardInputSnatcher();

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
	public void proCon005_mainTestData() {
		proCon005_main(
				5,
				new int[]{1, 2, 4, 6,  8},
				new int[]{3, 5, 7, 9, 10},
				"count = 3");
		
		proCon005_main(
				6,
				new int[]{1,  1, 2, 4, 6, 8},
				new int[]{10, 3, 5, 7, 9, 10},
				"count = 3");
		
		proCon005_main(
				12,
				new int[]{1,  1, 2, 4, 6,  8, 2, 4,  9, 1, 3, 5},
				new int[]{10, 3, 5, 7, 9, 10, 3, 5, 10, 2, 4, 8},
				"count = 4");
	}

	private void proCon005_main(int n, int[] s, int[] t, String expected) {
		// 初期化
		setInit(n, s, t);
		
		// テスト対象の実行
		ProCon005.main(new String[]{});

		// 出力は改行ごとに取得される(今回は一行のみ)
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	private void setInit(int n, int[] s, int[] t) {
		ProCon005.n = n;
		ProCon005.s = s;
		ProCon005.t = t;
		ProCon005.arrayS = new ArrayList<Integer>();
		ProCon005.arrayT = new ArrayList<Integer>();
	}
}
