package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon004Test {
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
	public void proCon004_mainTestData() {
		proCon004_main(
				new int[]{10, 1, 5, 5, 4, 2},
				1456,
				new String[]{"500 = 2", "100 = 4", "50 = 1", "10 = 0", "5 = 1", "1 = 1", "sum = 9"});
		
		proCon004_main(
				new int[]{3, 2, 1, 3, 0, 2},
				620,
				new String[]{"500 = 1", "100 = 0", "50 = 2", "10 = 1", "5 = 2", "1 = 0", "sum = 6"});
	}

	private void proCon004_main(int[] arrayInput, int A, String[] expected) {
		// 初期化
		setInit(arrayInput, A);
		
		// テスト対象の実行
		ProCon004.main(new String[]{});

		// 出力は改行ごとに取得される
		for(String exp : expected) {
			String actual = out.readLine();
			assertThat(actual, is(exp));
		}
	}
	
	private void setInit(int[] arrayInput, int A) {
		ProCon004.arrayInput      = arrayInput;						// コイン枚数設定限界値
		ProCon004.arrayExpectancy = new int[ProCon004.coinTypeNum];	// コイン枚数予測値
		ProCon004.A               = A;								// 設定金額
	}
}
