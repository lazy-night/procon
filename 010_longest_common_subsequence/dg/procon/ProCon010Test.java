package procon;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class ProCon010Test {
	@Test
	public void run() throws Exception {
		getLCSTest(4, 4, "abcd", "becd", "3");
		getLCSTest(7, 6, "ABCBDAB", "BDCABA", "4");
	}
	
	public void getLCSTest(int n, int m, String s, String t, String expected) throws Exception {
		// 初期化
		setInit(s, t);

		// メソッドに必要な引数の型を設定
		Class<?>[] classArray = {int.class, int.class};
		Method method = ProCon010.class.getDeclaredMethod("getLCS", classArray);
		// privateメソッドの使用を許可
		method.setAccessible(true);

		// メソッドの実行（必要な引数を設定）
		Integer actual = (Integer)method.invoke(new ProCon010(), new Object[]{n-1, m-1});
		// 実行結果の検証
		assertThat(actual.toString(), is(expected));
	}
	
	private void setInit(String s, String t) {
		ProCon010.charS = s.toCharArray();
		ProCon010.charT = t.toCharArray();
	}
}
