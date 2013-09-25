package procon;

public class ProCon012 {
	static final int maxW = 100000000;		// 重さの最大値よりも大きな値を設定
	static int n   = 4;
	static int[] w = new int[]{2, 1, 3, 2};
	static int[] v = new int[]{3, 2, 4, 2};
	static int W   = 5;

	public static void main(String[] args) {
		// 結果表示
		System.out.println(run());
	}
	
	private static int run() {
		// 価値の最大値取得
		int maxValue = getMaxValue();
		
		// DPテーブル初期化
		int[][] dp = initDP(maxValue);
		
		// DPテーブル設定
		dp = setDP(dp, maxValue);

		// 価値の総和の最大値を取得
		return getResult(dp, maxValue);
	}
	
	private static int getMaxValue() {
		int maxValue = 0;
		for (int i = 0; i < n; i++) {
			if (v[i] > maxValue)
				maxValue = v[i];
		}
		return maxValue;
	}
	
	private static int[][] initDP(int maxValue) {
		// DPテーブル作成
		int[][] dp = new int[n + 1][n * maxValue + 1];
		
		// n=0に関しての初期値を設定
		for (int i = 0; i < n * maxValue + 1; i++)
			dp[0][i] = maxW;
		dp[0][0] = 0;
		
		return dp;
	}
	
	private static int[][] setDP(int[][] dp, int maxValue) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n * maxValue; j++) {
				if (j < v[i]) {
					dp[i + 1][j] = dp[i][j];
				}
				else {
					dp[i + 1][j] = min(dp[i][j], dp[i][j - v[i]] + w[i]);
				}
			}
		}
		return dp;
	}
	
	private static int min(int el1, int el2) {
		if (el1 != 0 && el1 < el2) return el1;
		else return el2;
	}
	
	private static int getResult(int[][] dp, int maxValue) {
		int res = 0;
		for (int i = 0; i <= n * maxValue; i++)
			if (dp[n][i] <= W)
				res = i;
		return res;
	}
}