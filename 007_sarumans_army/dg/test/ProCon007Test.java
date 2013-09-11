package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon007Test {
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
	public void proCon007_mainTestData() {
		proCon007_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\007_inputText\\ProCon007_input.txt",
				new String[]{"2", "4"});
	}

	private void proCon007_main(String filename, String[] expected) {
		// 初期化
		setInit(filename);
		
		// テスト対象の実行
		ProCon007.main(new String[]{});

		// 出力は改行ごとに取得される
		for(String exp : expected) {
			String actual = out.readLine();
			assertThat(actual, is(exp));
		}
	}
	
	private void setInit(String filename) {
		ProCon007.filename = filename;
	}
}
