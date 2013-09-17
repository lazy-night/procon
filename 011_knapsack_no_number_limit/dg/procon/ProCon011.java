package procon;

import java.util.ArrayList;

public class ProCon011 {
	static int n   = 3;
	static int[] w = new int[] { 3, 4, 2 };
	static int[] v = new int[] { 4, 5, 3 };
	static int W   = 7;

	public static void main(String[] args) {
		// 結果表示
		System.out.println(run());
	}

	private static int run() {
		W = W + 1;		// 重さ・価値ともに0を含めるため
		int[] valueOfEachWeight   = new int[W];
		ArrayList<Integer> arrayW = new ArrayList<Integer>();
		ArrayList<Integer> arrayV = new ArrayList<Integer>();

		// 初期化
		for (int i = 0; i < W; i++)
			valueOfEachWeight[i] = 0;
		for (int i = 0; i < n; i++) {
			arrayW.add(w[i]);
			arrayV.add(v[i]);
		}

		// 重さごとの価値を調査
		valueOfEachWeight = knapSack(valueOfEachWeight, arrayW, arrayV, 0);

		// 価値の最大値探索
		return getMaxValue(valueOfEachWeight);
	}

	private static int getMaxValue(int[] valueOfEachWeight) {
		int max = 0;
		for (int i = 0; i < W; i++) {
			if (valueOfEachWeight[i] > max)
				max = valueOfEachWeight[i];
		}
		return max;
	}

	private static int[] knapSack(int[] valueOfEachWeight, ArrayList<Integer> arrayW, ArrayList<Integer> arrayV, int sumW) {
		// リストが空なので、処理終了
		if (arrayW.size() == 0)
			return valueOfEachWeight;

		// コピーリストの作成
		ArrayList<Integer> arrayW_copy = copyArrayInteger(arrayW);
		ArrayList<Integer> arrayV_copy = copyArrayInteger(arrayV);

		// 現在選択中の要素（コピーリストからは削除）
		int weight = arrayW_copy.remove(0);
		int value = arrayV_copy.remove(0);

		// 現在選択中の要素を付加しない場合
		int[] noAddValue = knapSack(valueOfEachWeight, arrayW_copy, arrayV_copy, sumW);

		// 現在選択中の要素を付加した場合
		sumW += weight;
		// 最大容量を超えた場合は処理終了
		if (sumW > W)
			return valueOfEachWeight;
		int[] addValue = knapSack(addValue(valueOfEachWeight, weight, value), arrayW, arrayV, sumW);

		// 価値の最適解を取得
		return getOptimalSolution(valueOfEachWeight, noAddValue, addValue);
	}

	// リストのコピー
	private static ArrayList<Integer> copyArrayInteger(ArrayList<Integer> arrayOriginal) {
		ArrayList<Integer> arrayCopy = new ArrayList<Integer>();
		for (int i = 0; i < arrayOriginal.size(); i++)
			arrayCopy.add(arrayOriginal.get(i));
		return arrayCopy;
	}

	// 指定要素を付加
	private static int[] addValue(int[] valueOfEachWeight, int weight, int value) {
		int[] result = new int[W];
		for (int i = 0; i < W; i++)
			result[i] = valueOfEachWeight[i];

		for (int i = 0; i < W; i++) {
			if ((i + weight < W) && (i == 0 || valueOfEachWeight[i] != 0))
				result[i + weight] = valueOfEachWeight[i] + value;
		}
		return result;
	}

	// 最適解の取得
	private static int[] getOptimalSolution(int[] optimalSolution, int[] noAddValue, int[] addValue) {
		for (int i = 0; i < W; i++) {
			if (noAddValue[i] > addValue[i])
				optimalSolution[i] = noAddValue[i];
			else
				optimalSolution[i] = addValue[i];
		}
		return optimalSolution;
	}
}