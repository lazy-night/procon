// [TODO]パッケージは適宜変更してください
package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class ProCon002 {
	static int row;					// 行数
	static int column;				// 列数
	static char[][] arrayInput;		// 入力データ
	static int groupCount = 0;		// アウトプット用グループ合計数

	public static void main(String[] args) {
		// ファイル読み込み
		readInputFile();

		// 初期状態表示
		System.out.println(row + " " + column);
		displayArrayInputList();

		// 'W'探索
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arrayInput[i][j] == 'W') {
					// 該当'W'に属する'W'の調査
					checkGroup(i, j);
				}
			}
		}

		// 結果の表示
		//displayArrayInputList();
		System.out.println("groupCount = " + groupCount);
	}

	/**
	 * 入力テキストファイルを読み込む メンバ変数に値を設定している
	 */
	public static void readInputFile() {
		try {
			File file = new File(
					"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\example\\ProCon002_input.txt");
			FileReader fr = new FileReader(file);			// FileReaderオブジェクトの作成

			StreamTokenizer st = new StreamTokenizer(fr);	// StreamTokenizerオブジェクトの作成
			st.nextToken();
			row = (int) st.nval;							// 行
			st.nextToken();
			column = (int) st.nval;							// 列

			int ch;
			ch = fr.read();									// 改行コード分読み進める
			arrayInput = new char[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					ch = fr.read();
					if (ch != 10 && ch != 13) {
						arrayInput[i][j] = (char) ch;		// 改行コードは除く
					}
					else {
						j = j - 1;
					}
				}
			}

			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * データ状態を表示する
	 */
	public static void displayArrayInputList() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arrayInput[i][j]);
			}
			System.out.println("");
		}

		System.out.println("");
	}

	/** 
	 * 対象'W'の座標からその'W'に属する'W'を調査する
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 */
	public static void checkGroup(int x, int y) {
		// 対象'W'を'.'に変換し、グループカウント数を加算する
		converted_into_A(x, y, '.');
		groupCount++;

		// 基準点周囲の'W'を探索する
		search_W_around_point(x, y);

		// 今回探索した'W'と同グループである'X'を探索
		while (bool_search_X()) {
			// デバッグ用
			//displayArrayInputList();
		}
	}

	/** 
	 * 対象'W'をAに変換
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 * @param  A	変換先
	 */
	public static void converted_into_A(int x, int y, char A) {
		arrayInput[x][y] = A;
	}

	/** 
	 * 対象'W'周辺の'W'を'X'に変換
	 *
	 * @param  x	対象'W'のX座標
	 * @param  y	対象'W'のY座標
	 */
	public static void search_W_around_point(int x, int y) {
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
	public static boolean bool_search_X() {
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
