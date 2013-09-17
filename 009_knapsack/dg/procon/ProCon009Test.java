package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon009Test {
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
	public void proCon009_mainTestData() {
		proCon009_main(
				4,
				new int[]{2, 1, 3, 2},
				new int[]{3, 2, 4, 2},
				5,
				"7");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				10,
				"14");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				9,
				"13");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				8,
				"11");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				7,
				"11");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				6,
				"11");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				5,
				"9");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				4,
				"8");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				3,
				"6");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				2,
				"3");
		
		proCon009_main(
				5,
				new int[]{3, 4, 1, 2, 3},
				new int[]{2, 3, 2, 3, 6},
				1,
				"2");
	}

	private void proCon009_main(int n, int[] w, int[] v, int W, String expected) {
		// 初期化
		setInit(n, w, v, W);
		
		// テスト対象の実行
		ProCon009.main(new String[]{});

		// 出力は改行ごとに取得される
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	private void setInit(int n, int[] w, int[] v, int W) {
		ProCon009.n = n;
		ProCon009.w = w;
		ProCon009.v = v;
		ProCon009.W = W;
	}
}
