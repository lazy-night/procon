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
				convertSamePlaceToMinus();
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
	 * 同じ場所にいる兵士に関して、一人を除いて場所を-1にする
	 * (同じ場所に兵士が重複しないようにする)
	 */
	public static void convertSamePlaceToMinus() {
		int tmp = xn[0];
		for (int i = 1; i < n; i++) {
			if(tmp == xn[i]) {
				xn[i] = -1;
			}
			else {
				tmp = xn[i];
			}
		}
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
	 * @param int element  現在の要素
	 * @param int nextPoint 次の要素の位置
	 * 
	 * @return true  範囲内
	 * @return false 範囲外
	 */
	private static boolean isRange(int element, int nextPoint) {
		if ((nextPoint < n) && (xn[nextPoint] - element <= R))
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
		for (int i = 0; i < n; i++) {
			// 重複した要素は考慮しない
			if(xn[i] == -1) continue;
			
			// 魔法石加算
			palantirs++;
			
			// iの位置から右側に関して、石の影響が届く最も遠い人の場所を取得
			int location = getInfluenceOfPalantir(i);
			// 最も遠い人が影響範囲外ならば次の処理を行わない
			if(location >= R) continue;
			
			// 石の所持者の場所(配列番号)
			i = i + location;
			// 石の所持者から右側に関して、石の影響が届く最も遠い人の場所を取得
			location = getInfluenceOfPalantir(i);
			// 最も遠い人が影響範囲外ならば次の処理を行わない
			if(location >= R) continue;
			
			// 石の所持者から石の影響が届く最も遠い人の場所(配列番号)
			i = i + location;
		}
		return palantirs;
	}
	
	/** 
	 * 魔法石の影響範囲
	 *
	 * @return 魔法石の影響範囲内で最も遠い人の配列番号(Rの場合は配列番号なので、影響範囲外となる)
	 */
	private static int getInfluenceOfPalantir(int i) {
		for(int j = 1; j < R + 1; j++)
			if(!isRange(xn[i], i + j))
				return j - 1;
		return R;
	}
}
