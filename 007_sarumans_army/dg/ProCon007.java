package procon;

import java.util.ArrayList;
import java.util.Arrays;

import lib.ControllFile;

public class ProCon007 {
	static String filename = "C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\007_inputText\\ProCon007_input.txt";
	static int R = 0;
	static int n = 0;
	static int[] xn;
	
	public static void main(String[] args) {
		// ファイル読み込み
		ControllFile file = new ControllFile();
		ArrayList<String> arrayInput = file.readInputFile(filename);

		int i = 0;
		for (String line : arrayInput) {
			String[] elements = line.split(" ");

			// 1行目([R, n] or [EOF])
			if (i % 2 == 0) {
				R = Integer.parseInt(elements[0]);
				n = Integer.parseInt(elements[1]);
			}
			// 2行目(xn)
			else {
				xn = getParseIntPositions(elements);
				Arrays.sort(xn);
				System.out.println(getRequiredPalantirs());
			}
			i++;
		}
	}

	/** 
	 * 兵士の位置をString[]からInt[]に変換する
	 *
	 * @param String[] elements 兵士の位置
	 * 
	 * @return int[] 兵士の位置
	 */
	private static int[] getParseIntPositions(String[] elements) {
		int[] armyPositions = new int[n];
		for (int i = 0; i < n; i++) {
			armyPositions[i] = Integer.parseInt(elements[i]);
		}
		return armyPositions;
	}

	/** 
	 * 必要な魔法石の個数を取得する
	 *
	 * @return 0 兵士がいない場合
	 * @return 1 兵士が一人の場合
	 * @return 必要な魔法石の個数計算結果
	 */
	private static int getRequiredPalantirs() {
		if (xn.length == 0)
			return 0;
		if (xn.length == 1)
			return 1;
		
		return calcPalantirs();
	}

	/** 
	 * 現在の位置から次の位置にいる兵士が指定範囲内にいるかを判定する
	 *
	 * @param int point  現在の位置
	 * @param int fPoint 次の位置
	 * 
	 * @return true  範囲内
	 * @return false 範囲外
	 */
	private static boolean isRange(int point, int fPoint) {
		if (fPoint - point <= R)
			return true;
		else
			return false;
	}
	
	/** 
	 * 必要な魔法石の計算
	 *
	 * @return 必要な魔法石の個数
	 */
	private static int calcPalantirs() {
		int palantirs = 0;
		for (int first = 0; first < n; first++) {
			// 魔法石加算
			palantirs++;
			
			int second = first + 1;
			
			// 1,2番目の要素が指定範囲内にあるか判定
			if ((second < n) && isRange(xn[first], xn[second])) {
				int third = second + 1;
				
				// 2,3番目の要素が指定範囲内にあるか判定
				if ((third < n) && isRange(xn[second], xn[third]))
					// 3番目の要素が指定範囲内にあるので、次は4番目の要素を調べる
					first = third;
				else
					// 3番目の要素が指定範囲外にあるので、次は3番目の要素を調べる
					first = second;
			}
		}
		return palantirs;
	}
}
