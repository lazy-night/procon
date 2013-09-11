package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon006Test {
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
	public void proCon006_mainTestData() {
		proCon006_main(
				6,
				new char[]{'A', 'C', 'D', 'B', 'C', 'B'},
				"Old : ACDBCB",
				"New : ABCBCD");
		
		proCon006_main(
				6,
				new char[]{'A', 'C', 'B', 'B', 'C', 'A'},
				"Old : ACBBCA",
				"New : AACBBC");
		
		proCon006_main(
				7,
				new char[]{'A', 'C', 'C', 'D', 'B', 'C', 'A'},
				"Old : ACCDBCA",
				"New : AACBCCD");
		
		proCon006_main(
				8,
				new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'},
				"Old : AAAAAAAA",
				"New : AAAAAAAA");
	}

	public void proCon006_main(int numberOfCow, char[] cowLine, String expectedOld, String expectedNew) {
		// 入力設定値
		setInit(numberOfCow, cowLine);
		
		// テスト対象の実行
		ProCon006.main(new String[]{});

		// 出力は改行ごとに取得される
		String actualOld = out.readLine();
		String actualNew = out.readLine();
		assertThat(actualOld, is(expectedOld));
		assertThat(actualNew, is(expectedNew));
	}
	
	public static void setInit(int numberOfCow, char[] cowLine) {
		ProCon006.numberOfCow     = numberOfCow;
		ProCon006.cowLine         = cowLine;
		ProCon006.arrayCowLine    = new ArrayList<Character>();
		ProCon006.arrayNewCowLine = new ArrayList<Character>();
	}
}
