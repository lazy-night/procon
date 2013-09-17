package procon;

import java.util.ArrayList;


public class ProCon009 {
	static int n   = 4;
	static int[] w = new int[]{2, 1, 3, 2};
	static int[] v = new int[]{3, 2, 4, 2};
	static int W   = 5;

	public static void main(String[] args) {
		W = W + 1;
		int[] valueOfEachWeight        = new int[W];
		ArrayList<Integer> arrayWeight = new ArrayList<Integer>();
		ArrayList<Integer> arrayValue  = new ArrayList<Integer>();
		
		// 初期化
		for (int i = 0; i < W; i++)
			valueOfEachWeight[i] = 0;
		for (int i = 0; i < n; i++) {
			arrayWeight.add(w[i]);
			arrayValue.add(v[i]);
		}
		
		valueOfEachWeight = knapSack(valueOfEachWeight, arrayWeight, arrayValue);
		
		// 最大値探索
		int max = 0;
		for (int i = 0; i < W; i++) {
			if (valueOfEachWeight[i] > max)
				max = valueOfEachWeight[i];
		}
		
		// 結果表示
		System.out.println(max);
	}
	
	private static int[] knapSack(int[] valueOfEachWeight, ArrayList<Integer> arrayW, ArrayList<Integer> arrayV) {
		if (arrayW.size() == 0) return valueOfEachWeight;
		
		// 現在選択中の価値と重さ
		int weight = arrayW.remove(0);
		int value  = arrayV.remove(0);
		
		// 選択中の価値と重さを付加or付加しないで場合分けし、再帰的に処理を行う
		int[] addValue   = knapSack(addValue(valueOfEachWeight, weight, value), arrayW, arrayV);
		int[] noAddValue = knapSack(valueOfEachWeight, arrayW, arrayV);
		
		// 価値の最適解を取得
		return getOptimalSolution(valueOfEachWeight, noAddValue, addValue);
	}
	
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