package procon;

public class ProCon004 {
	static final int coinTypeNum = 6;								// コイン種類枚数
	static final int[] coinType  = { 1, 5, 10, 50, 100, 500 };		// コイン種類
	static int[] arrayInput      = new int[]{10, 1, 5, 5, 4, 2};	// コイン枚数設定限界値
	static int[] arrayExpectancy = new int[coinTypeNum];			// コイン枚数予測値
	static int A                 = 1456;							// 設定金額

	public static void main(String[] args) {
		// 調査対象配列番号
		int target = coinTypeNum - 1;
		
		minCoins(target);
		while (bool_forecastVerification(target)){
			adjustmentOfExpectancy(target--);
		}
		
		// 結果出力
		displayResult();
	}

	/** 
	 * 最小構成枚数を設定する
	 *
	 * @param  target	対象配列番号
	 */
	public static void minCoins(int target) {
		int rest = A;
		for (int i = target; i >= 0; i--) {
			arrayExpectancy[i] = rest / coinType[i];
			rest = A % coinType[i];

			if (rest == 0){
				A = 0;
				break;
			}
		}
	}
	
	/** 
	 * 結果表示
	 */
	public static void displayResult() {
		int sum = 0;
		for (int i = 5; i >= 0; i--) {
			System.out.println(coinType[i] + " = " + arrayExpectancy[i]);
			sum += arrayExpectancy[i];
		}
		System.out.println("sum = " + sum);
	}
	
	/** 
	 * 予測コイン枚数調整
	 * 
	 * @param  target	対象配列番号
	 */
	public static void adjustmentOfExpectancy(int target) {
		// 枚数限界値と予測枚数の比較
		if (arrayInput[target] < arrayExpectancy[target]) {
			// 予測枚数が大きい場合、Aに余剰分を設定する
			A = (arrayExpectancy[target] - arrayInput[target]) * coinType[target];
			// 予測枚数には枚数限界値を設定
			arrayExpectancy[target] = arrayInput[target];
			
			// 調査対象番号よりも小さい番号内で、A（余剰分）を分配し予測コイン枚数を再度算出する
			minCoins(target - 1);
		}
	}
	
	/** 
	 * 予測コイン枚数検証
	 *
	 * @param  target	対象配列番号
	 * 
	 * @return  true 検証失敗
	 */
	public static boolean bool_forecastVerification(int target) {
		for (int i = target; i >= 0; i--) {
			// 枚数限界値と予測枚数の比較
			if (arrayInput[i] < arrayExpectancy[i]) return true;
		}
		return false;
	}
}
