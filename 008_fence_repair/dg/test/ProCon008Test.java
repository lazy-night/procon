package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon008Test {
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
	public void proCon008_mainTestData() {
		proCon008_main(
				3,
				new int[]{8, 5, 8},
				"34");

		proCon008_main(
				4,
				new int[]{7, 5, 3, 1},
				"29");

		proCon008_main(
				6,
				new int[]{5, 5, 5, 2, 5, 5},
				"85");

 		// 不適切だったらお手数ですが消してください。。
		proCon008_main(
				8,
				new int[]{5, 3, 10, 8, 6, 4, 7, 9},
				"153");
	}

	private void proCon008_main(int N, int[] li, String expected) {
		// 初期化
		setInit(N, li);

		// テスト対象の実行
		ProCon008.main(new String[]{});

		// 出力は改行ごとに取得される
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}

	private void setInit(int N, int[] li) {
		ProCon008.N = N;
		ProCon008.li = li;
	}
}
