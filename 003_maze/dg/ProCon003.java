package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProCon003 {
	static final int N = 10;		// 縦
	static final int M = 10;		// 横
	static char[][] arrayInput;		// 入力データ

	public static void main(String[] args) {
		// 速度計測(start)
		long start_nano = System.nanoTime();
		
		// ファイル読み込み
		readInputFile();

		// 初期状態表示
		System.out.println(N + " * " + M);
		displayArrayInputList();
		
		// スタート地点の探索
		int[] startPoint = getStartPoint();
		if (startPoint == null) {
			// 'S'が存在しないので、強制終了
			System.out.println("S doesn't exist.");
			return;
		}
		
		// 最短経路探索
		int shortestPath = getShortestPath(startPoint[0], startPoint[1], 0, arrayInput);
		
		// 結果出力
		System.out.println("Shortest Path = " + shortestPath);
		
		// 速度計測(stop)
		long stop_nano = System.nanoTime();
		System.out.println("実行にかかった時間は " + (stop_nano - start_nano) + " ナノ秒です。");
	}

	/**
	 * 入力テキストファイルを読み込む メンバ変数に値を設定している
	 */
	public static void readInputFile() {
		try {
			File file = new File(
					"C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\example\\ProCon003_input.txt");
			FileReader fr = new FileReader(file);			// FileReaderオブジェクトの作成

			int ch;
			arrayInput = new char[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ch = fr.read();
					if (ch != 10 && ch != 13) {
						arrayInput[i][j] = (char) ch;		// 改行コードは除く
					}
					else j = j - 1;
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
	 * 入力データ状態を表示する
	 */
	public static void displayArrayInputList() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arrayInput[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	/**
	 * スタート地点探索
	 * 
	 * @return スタート地点の座標
	 */
	public static int[] getStartPoint() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrayInput[i][j] == 'S') {
					int[] startPoint = new int[2];
					startPoint[0] = i;
					startPoint[1] = j;
					return startPoint;
				}
			}
		}
		return null;
	}

	/**
	 * 最短経路探索
	 * 
	 * @param  x				対象位置のX座標
	 * @param  y				対象位置のY座標
	 * @param  count			行動回数
	 * @param  arrayInputCopy	入力データ
	 * 
	 * @return 最短経路の行動回数
	 */
	public static int getShortestPath(int x, int y, int count, char[][] arrayInputCopy) {
		// 現在の場所を通れないようにする
		arrayInputCopy[x][y] = 'X';
		
		// 上下左右に値('G')があるかの判定
		if ((x - 1 >= 0 && arrayInputCopy[x - 1][y] == 'G')
			|| (x + 1 <  N && arrayInputCopy[x + 1][y] == 'G')
			|| (y - 1 >= 0 && arrayInputCopy[x][y - 1] == 'G')
			|| (y + 1 <  M && arrayInputCopy[x][y + 1] == 'G')) return count + 1;
		
		// 初期値に-1を設定し、'G'にたどり着かない場合は-1を返す
		int[] arrayCount = new int[] {-1, -1, -1, -1};
		// 上下左右に値('.')があるかの判定
		// '.'だった場合、その先へ行ったと仮定して、再帰的に経路をカウントする
		if (x - 1 >= 0 && arrayInputCopy[x - 1][y] == '.')
			arrayCount[0] = getShortestPath(x - 1, y, count + 1, arrayInputCopy);
		if (x + 1 <  N && arrayInputCopy[x + 1][y] == '.')
			arrayCount[1] = getShortestPath(x + 1, y, count + 1, arrayInputCopy);
		if (y - 1 >= 0 && arrayInputCopy[x][y - 1] == '.')
			arrayCount[2] = getShortestPath(x, y - 1, count + 1, arrayInputCopy);
		if (y + 1 <  M && arrayInputCopy[x][y + 1] == '.')
			arrayCount[3] = getShortestPath(x, y + 1, count + 1, arrayInputCopy);
		
		// 最短経路を調べる
		int tmp = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) 
			if (-1 != arrayCount[i] && tmp > arrayCount[i]) tmp = arrayCount[i];
		if (tmp == Integer.MAX_VALUE) tmp = -1;
		
		return tmp;
	}
}
