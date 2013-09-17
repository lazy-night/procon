package procon;

public class ProCon010 {
	static int n        = 4;
	static int m        = 4;
	static String s     = "abcd";
	static String t     = "becd";
	static char[] charS = new char[]{};
	static char[] charT = new char[]{};

	public static void main(String[] args) {
		charS = s.toCharArray();
		charT = t.toCharArray();

		// 結果表示
		System.out.println(getLCS(n - 1, m - 1));
	}
	
	private static int getLCS(int i, int j) {
		if (i == -1 || j == -1)
			return 0;
		else if (charS[i] == charT[j])
			return getLCS(i - 1, j - 1) + 1;
		else
			return getMaxLCS(getLCS(i - 1, j), getLCS(i, j - 1));
	}
	
	private static int getMaxLCS(int el1, int el2) {
		if (el1 > el2)
			return el1;
		else
			return el2;
	}
}