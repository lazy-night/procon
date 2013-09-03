// [TODO]パッケージは適宜変更してください
package example;

import java.util.ArrayList;

public class ProCon001 {
	static int purpose;
	
	public static void main(String[] args) {
		// [TODO] 最初に引数のチェックを入れるべき
		
		int elements_num = Integer.parseInt(args[0]);				// 要素数
		purpose = Integer.parseInt(args[1]);						// 目標値
		ArrayList<Integer> arrayA      = new ArrayList<Integer>();	// 要素格納用
		ArrayList<Integer> arraySelect = new ArrayList<Integer>();	// 選択した数値格納用
		
		// 引数から要素詰め替え
		for(int i = 2; i < elements_num + 2; i++) {
			arrayA.add(Integer.parseInt(args[i]));
		}
		
		// 出力結果
		if (search(arrayA, arraySelect, 0)) {
			System.out.print(purpose + " = {");
			for (int i = 0; i < arraySelect.size(); i++) {
				if (i != 0) System.out.print(", ");
				System.out.print(arraySelect.get(i));
			}
			System.out.println("}");
		}
		else {
			System.out.println("Failure");
		}
	}

	/** 
	 * 判定用再帰関数
	 * 表示用データを設定する
	 *
	 * @param  arrayA		入力されたデータa
	 * @param  arraySelect	表示データ
	 * @param  sum			合計値
	 * 
	 * @return  表示の可否
	 */
	public static boolean search(ArrayList<Integer> arrayA, ArrayList<Integer> arraySelect, int sum) {
		int car = (Integer) arrayA.get(0);									// 現在選択中の値
		arrayA.remove(0);													// 選択中の値をリストから削除
		ArrayList<Integer> arrayA_copy = new ArrayList<Integer>(arrayA);	// リストの現状態を保存
		sum += car;															// 合計値の設定
		
		if (purpose == sum) {
			arraySelect.add(car);											// 選択中の値を表示用リストに追加
			return true;
		}
		else if (arrayA.size() != 0){
			// 現在選択中の値を含める場合の判定
			if (search(arrayA, arraySelect, sum)) {
				arraySelect.add(car);										// 選択中の値を表示用リストに追加
				return true;
			}
			// 現在選択中の値を含めない場合の判定
			else if (search(arrayA_copy, arraySelect, sum - car))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}