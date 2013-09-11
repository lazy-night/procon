package procon;

import lib.ControllFile;

public class ProCon003 {
	static String filename = "C:\\pleiades\\workspace_Java\\junit_test\\src\\main\\java\\procon\\003_maze\\ProCon003_input.txt";
	static int N = 10;		// 縦
	static int M = 10;		// 横

	public static void main(String[] args) {
		// ファイル読み込み
		ControllFile file   = new ControllFile();
		char[][] arrayInput = file.readInputFile(filename, N, M);

		// スタート, ゴール地点の探索
		int[] sPoint = getPoint(arrayInput, 'S');
		if (sPoint == null || getPoint(arrayInput, 'G') == null) {
			// 'S'or'G'が存在しないので、強制終了
			System.out.println("Set 'S' and 'G'.");
		}
		else {
			// 最短経路探索し、結果出力
			System.out.println("Shortest Path = " + getShortestPath(sPoint[0], sPoint[1], 0, arrayInput));
		}
	}
	
	/**
	 * 基準点探索
	 * 
	 * @param  arrayInputCopy	入力データ
	 * @param  point			基準点
	 * 
	 * @return 基準点の座標
	 */
	private static int[] getPoint(char[][] arrayInput, char point) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrayInput[i][j] == point) {
					int[] sPoint = new int[2];
					sPoint[0] = i;
					sPoint[1] = j;
					return sPoint;
				}
			}
		}
		return null;
	}

	/**
	 * 最短経路取得
	 * 
	 * @param  x				対象位置のX座標
	 * @param  y				対象位置のY座標
	 * @param  count			行動回数
	 * @param  arrayInputCopy	入力データ
	 * 
	 * @return 最短経路の行動回数
	 */
	private static int getShortestPath(int x, int y, int count, char[][] arrayInputCopy) {
		// 現在の場所を通れないようにする
		arrayInputCopy[x][y] = 'X';
		
		// 上下左右の値設定
		char[] topBottomLeftRight = setTopBottomLeftRight(x, y, arrayInputCopy);
		
		// 上下左右に値('G')があるかの判定
		for (int i = 0; i < 4; i++) 
			if (topBottomLeftRight[i] == 'G') return count + 1;
		
		// 上下左右 X座標, Y座標
		int xPoint[] = new int[]{x, x, x - 1, x + 1};
		int yPoint[] = new int[]{y - 1, y + 1, y, y};
				
		// 初期値に-1を設定し、'G'にたどり着かない場合は-1を返す
		int[] arrayCount = new int[] {-1, -1, -1, -1};
		
		// 上下左右に値('.')があるかの判定
		// '.'だった場合、その先へ行ったと仮定して、再帰的に経路をカウントする
		for (int i = 0; i < 4; i++) 
			if (topBottomLeftRight[i] == '.')
				arrayCount[i] = getShortestPath(xPoint[i], yPoint[i], count + 1, arrayInputCopy);
		
		// 最短経路を調べる
		return searchShortestPath(arrayCount);
	}
	
	/**
	 * 基準点における上下左右の値設定
	 * 
	 * @param  x	基準点のx座標
	 * @param  y	基準点のy座標
	 * @param  arrayInputCopy	入力データ
	 * 
	 * @return 基準点における上下左右の値
	 */
	private static char[] setTopBottomLeftRight(int x, int y, char[][] arrayInputCopy) {
		char[] topBottomLeftRight = new char[]{'X', 'X', 'X', 'X'};
		if (y - 1 >= 0) topBottomLeftRight[0] = arrayInputCopy[x][y - 1];
		if (y + 1 <  M) topBottomLeftRight[1] = arrayInputCopy[x][y + 1];
		if (x - 1 >= 0) topBottomLeftRight[2] = arrayInputCopy[x - 1][y];
		if (x + 1 <  N) topBottomLeftRight[3] = arrayInputCopy[x + 1][y];
		
		return topBottomLeftRight;
	}
	
	/**
	 * 最短経路探索
	 * 
	 * @param  arrayCount	各経路における'G'までの最短経路の行動回数
	 * 
	 * @return 最短経路の行動回数(-1はゴールまでの道がないことを指す)
	 */
	private static int searchShortestPath(int[] arrayCount) {
		int tmp = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) 
			if (-1 != arrayCount[i] && tmp > arrayCount[i])
				tmp = arrayCount[i];
		if (tmp == Integer.MAX_VALUE) tmp = -1;
		
		return tmp;
	}
}
