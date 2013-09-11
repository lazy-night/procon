package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon001Test {
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
	public void proCon001_mainTestData() {
		proCon001_main(
				new String[]{"5", "20", "18", "-4", "-5", "7", "1"},
				"20 = {-5, 7, 18}");
		
		proCon001_main(
				new String[]{"4", "13", "1", "2", "4", "7"},
				"13 = {2, 4, 7}");
		
		proCon001_main(
				new String[]{"4", "15", "1", "2", "4", "7"},
				"Failure");
	}
	
	private void proCon001_main(String[] args, String expected) {
		// 初期化
		setInit();
		
		// 標準入力への入力はあらかじめ全部与える。
		for (String arg : args) in.inputln(arg);

		// テスト対象の実行
		ProCon001.main(args);

		// 出力は改行ごとに取得される(今回は一行のみ)
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	private void setInit() {
		ProCon001.arraySelect = new ArrayList<Integer>();
	}
}
