package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon002Test {
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
	public void proCon002_mainTestData() {
		proCon002_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\002_lake_counting\\ProCon002_input.txt",
				10,
				12,
				"groupCount = 3");
		
		proCon002_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\002_lake_counting\\ProCon002_input2.txt",
				10,
				12,
				"groupCount = 6");
	}

	private void proCon002_main(String filename, int row, int column, String expected) {
		// 初期化
		setInit(filename, row, column);
		
		// テスト対象の実行
		ProCon002.main(new String[]{});

		// 出力は改行ごとに取得される
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	private void setInit(String filename, int row, int column) {
		ProCon002.filename   = filename;
		ProCon002.row        = row;
		ProCon002.column     = column;
		ProCon002.arrayInput = null;
		ProCon002.groupCount = 0;
	}
}
