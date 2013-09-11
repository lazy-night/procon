package procon;

import lib.ControllFile;

public class ProCon002 {
	static String filename
	= "C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\002_lake_counting\\ProCon002_input.txt";
	static int row    = 10;			// 行数
	static int column = 12;			// 列数
	static char[][] arrayInput;		// 入力データ
	static int groupCount = 0;		// アウトプット用グループ合計数

	public static void main(String[] args) {
		// ファイル読み込み
		ControllFile file = new ControllFile();
		arrayInput = file.readInputFile(filename, row, column);

		// 'W'探索
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (arrayInput[i][j] == 'W')
					checkGroup(i, j);

		// 結果の表示
		System.out.println("groupCount = " + groupCount);
	}

	/** 
	 * 対象'W'の座標からその'W'に属する'W'を調査する
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 */
	private static void checkGroup(int x, int y) {
		// 対象'W'を'.'に変換し、グループカウント数を加算する
		converted_into_A(x, y, '.');
		groupCount++;

		// 基準点周囲の'W'を探索する
		search_W_around_point(x, y);

		// 今回探索した'W'と同グループである'X'を探索
		while (bool_search_X()) {}
	}

	/** 
	 * 対象'W'をAに変換
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 * @param  A	変換先
	 */
	private static void converted_into_A(int x, int y, char A) {
		arrayInput[x][y] = A;
	}

	/** 
	 * 対象'W'周辺の'W'を'X'に変換
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 */
	private static void search_W_around_point(int x, int y) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (x + i < 0 || y + j < 0 || x + i >= row || y + j >= column) {
					// 配列範囲外の場合は探索しない
				}
				// 'W'から'X'に変換する
				else if (arrayInput[x + i][y + j] == 'W')
					converted_into_A(x + i, y + j, 'X');
			}
		}
	}

	/** 
	 * 入力データに対して、'X'が一つでも含まれていたら、trueを返す
	 * なお、発見した'X'周辺の'W'も同時に調査し、必要があれば都度'X'に変換する
	 *
	 * @return  true	'X'発見
	 * @return  true	'X'なし
	 */
	private static boolean bool_search_X() {
		boolean flag = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arrayInput[i][j] == 'X') {
					// 'X'から'.'に変換する
					converted_into_A(i, j, '.');

					// 基準点周囲のWを探索する
					search_W_around_point(i, j);

					flag = true;
				}
			}
		}

		return flag;
	}
}
