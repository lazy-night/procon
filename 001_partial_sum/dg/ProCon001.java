
package procon;

import java.util.ArrayList;
import java.util.Collections;

public class ProCon001 {
	static int purpose;													// 目標値
	static ArrayList<Integer> arraySelect = new ArrayList<Integer>();	// 選択した数値格納用
	
	public static void main(String[] args) {
		// [TODO] 最初に引数のチェックを入れるべき
		
		int elements_num = Integer.parseInt(args[0]);			// 要素数
		purpose = Integer.parseInt(args[1]);
		ArrayList<Integer> arrayA = new ArrayList<Integer>();	// 要素格納用
		
		// 引数から要素詰め替え
		for(int i = 2; i < elements_num + 2; i++) {
			arrayA.add(Integer.parseInt(args[i]));
		}
		
		// 判定後、結果を表示
		displayResult(search(arrayA, 0));
	}

	/** 
	 * 判定用再帰関数
	 * 表示用データを設定する
	 *
	 * @param arrayA	入力されたデータ
	 * @param sum		合計値
	 * 
	 * @return 表示の可否
	 */
	public static boolean search(ArrayList<Integer> arrayA, int sum) {
		// 現在選択中の値を設定
		int car = (Integer) arrayA.get(0);
		arrayA.remove(0);
		sum += car;
		
		if (purpose == sum) {
			arraySelect.add(car);
			return true;
		}
		
		if (arrayA.size() != 0) {
			ArrayList<Integer> arrayA_copy = new ArrayList<Integer>(arrayA);
			
			// 現在選択中の値を含める場合の判定
			if (search(arrayA, sum)) {
				arraySelect.add(car);
				return true;
			}
			// 現在選択中の値を含めない場合の判定
			else if (search(arrayA_copy, sum - car))
				return true;
		}
		
		return false;
	}
	
	/** 
	 * 結果出力
	 *
	 * @param resultFlag 入力データで合計値が算出できるかのフラグ
	 */
	public static void displayResult(boolean resultFlag) {
		if (resultFlag) {
			// 出力内容をソート
			Collections.sort(arraySelect);
			
			System.out.print(purpose + " = {");
			for (int i = 0; i < arraySelect.size(); i++) {
				if (i != 0) System.out.print(", ");
				System.out.print(arraySelect.get(i));
			}
			System.out.println("}");
		}
		else System.out.println("Failure");
	}
}