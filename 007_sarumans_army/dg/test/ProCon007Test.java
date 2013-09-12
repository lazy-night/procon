package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
		
		proCon007_main(
				"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\007_inputText\\ProCon007_input2.txt",
				new String[]{"5", "2", "4"});
	}
	
	@Test
	public void convertSamePlaceToMinus() throws
	NoSuchMethodException,
	SecurityException,
	IllegalAccessException,
	IllegalArgumentException,
	InvocationTargetException
    {
		ProCon007.n  = 8;
		ProCon007.xn = new int[]{1, 5, 6, 9, 9, 10, 13, 20, 30, 40};
		int i = 0;
		int[] exp = new int[]{1, 5, 6, 9, -1, 10, 13, 20, 30, 40};
		
		Method method = ProCon007.class.getDeclaredMethod("convertSamePlaceToMinus");
		
		// trueをセットすることで、privateメソッドへアクセス可能となります。
		method.setAccessible(true);
		
		// privateメソッドを実行します。
		ProCon007 proCon007 = new ProCon007();
		
		// 第二引数以降が、メソッドの引数です。
		method.invoke(proCon007);
		
		for(int tmp : ProCon007.xn) {
			assertEquals(tmp, exp[i++]);
		}
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
