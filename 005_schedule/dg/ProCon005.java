package procon;

import java.util.ArrayList;

public class ProCon005 {
	static int   n = 6;								// 仕事数
	static int[] s = new int[]{8,2,6,1,4,1};		// 各仕事の開始時刻
	static int[] t = new int[]{10,3,9,5,7,3};		// 各仕事の終了時刻
	static ArrayList<Integer> arrayS = new ArrayList<Integer>();
	static ArrayList<Integer> arrayT = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// 入力データの詰め替え
		for(int i = 0; i < n; i++) {
			arrayS.add(s[i]);
			arrayT.add(t[i]);
		}
		
		int count = 0;
		while(removePairRangeOverlap(searchArrayT_minIndex())) {
			count++;
			if(arrayT.size() == 0) break;
		}
		
		// 結果を表示
		System.out.println("count = " + count);
	}

	/** 
	 * リストT内の要素が最小のインデックスを返す
	 *
	 * @return  インデックス
	 */
	private static int searchArrayT_minIndex() {
		int index = 0;
		int tmp   = Integer.MAX_VALUE;
		
		for(int i = 0; i < arrayT.size(); i++) {
			if(tmp > arrayT.get(i)) {
				tmp = arrayT.get(i);
				index = i;
			}
		}
		return index;
	}
	
	/** 
	 * 最小終了時刻を持つ[s, t]に重なるデータを削除する
	 *
	 * @param  minIndex		最小終了時刻を持つインデックス
	 * 
	 * @return  重なるデータがあった場合trueを返し、再度探索する
	 */
	private static boolean removePairRangeOverlap(int minIndex) {
		boolean flag = false;
		ArrayList<Integer> copyS = new ArrayList<Integer>(arrayS);
		ArrayList<Integer> copyT = new ArrayList<Integer>(arrayT);

		// for文は大きい要素から行わないと、removeする箇所がずれてしまう
		for(int i = copyT.size() - 1; i >= 0; i--) {
			if(copyT.get(minIndex) >= copyS.get(i)) {
				arrayS.remove(i);
				arrayT.remove(i);
				flag = true;
			}
		}
		return flag;
	}
}