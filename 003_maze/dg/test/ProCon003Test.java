package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import lib.StandardInputSnatcher;
import lib.StandardOutputSnatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProCon003Test {
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
	public void proCon003_mainTestData() {
		proCon003_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input.txt",
				10,
				10,
				"Shortest Path = 22");
		
		proCon003_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input2.txt",
				10,
				15,
				"Shortest Path = 32");
	}
	
	@Test
	public void proCon003_mainTestDataFailure() {
		// 'S'なし
		proCon003_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input_failure.txt",
				10,
				10,
				"Set 'S' and 'G'.");
		
		// 'G'なし
		proCon003_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input_failure2.txt",
				10,
				10,
				"Set 'S' and 'G'.");
		
		// 'S' and 'G'なし
		proCon003_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input_failure3.txt",
				10,
				10,
				"Set 'S' and 'G'.");
	}

	private void proCon003_main(String filename, int N, int M, String expected) {
		// 初期化
		setInit(filename, N, M);
		
		// テスト対象の実行
		ProCon003.main(new String[]{});

		// 出力は改行ごとに取得される
		String actual = out.readLine();
		assertThat(actual, is(expected));
	}
	
	private void setInit(String filename, int N, int M) {
		ProCon003.filename = filename;
		ProCon003.N        = N;
		ProCon003.M        = M;
	}
}
