package procon;

import java.util.ArrayList;

public class ProCon006 {
	static int numberOfCow = 6;
	static char[] cowLine = new char[]{'A', 'C', 'D', 'B', 'C', 'B'};
	static ArrayList<Character> arrayCowLine    = new ArrayList<Character>();
	static ArrayList<Character> arrayNewCowLine = new ArrayList<Character>();

	public static void main(String[] args) {
		// 入力データの詰め替え
		for(int i = 0; i < numberOfCow; i++)
			arrayCowLine.add(cowLine[i]);
		
		while(arrayCowLine.size() != 0) {
			int comp = compFirstToTail(arrayCowLine);
			if(comp == 0) {
				if(compSecondToSecondFromBehind(arrayCowLine) == 1)
					comp = 1;
				else
					comp = -1;
			}
			
			if(comp == 1)
				arrayNewCowLine.add(herdFirstCow());
			else
				arrayNewCowLine.add(herdLastCow());
		}
		
		// 結果を表示
		displayResult();
	}
	
	/** 
	 * リストの先頭要素を削除し、削除要素を返す
	 * 
	 * @return 削除対象要素
	 */
	public static char herdFirstCow() {
		return arrayCowLine.remove(0);
	}

	/** 
	 * リストの後尾要素を削除し、削除要素を返す
	 * 
	 * @return 削除対象要素
	 */
	public static char herdLastCow() {
		return arrayCowLine.remove(arrayCowLine.size() - 1);
	}
	
	/** 
	 * リストの先頭と後尾を比較する
	 *
	 * @param ArrayList<Character> cowLine 対象リスト
	 * 
	 * @return [先頭 == 後尾] 0
	 * @return [先頭 < 後尾]  1
	 * @return [先頭 > 後尾]  -1
	 */
	public static int compFirstToTail(ArrayList<Character> cowLine) {
		char first = cowLine.get(0);
		char tail  = cowLine.get(cowLine.size() - 1);
		
		if(first == tail)     return 0;
		else if(first < tail) return 1;
		else                  return -1;
	}
	
	/** 
	 * リストの先頭から二番目と後尾から二番目を比較する
	 *
	 * @param ArrayList<Character> cowLine 対象リスト
	 * 
	 * @return [先頭 == 後尾] このメソッドを再帰的に呼び出す
	 * @return [先頭 < 後尾]  1
	 * @return [先頭 > 後尾]  -1
	 */
	public static int compSecondToSecondFromBehind(ArrayList<Character> cowLine) {
		// 要素数が1のときはこのあとの処理を行わない
		if(cowLine.size() == 1) return 1;
		
		// 引数リストのコピーを作成し、前後の要素を削除する
		ArrayList<Character> cowLine_copy = new ArrayList<Character>(cowLine);
		cowLine_copy.remove(cowLine_copy.size() - 1);
		cowLine_copy.remove(0);
		
		// 要素数が0のときはこのあとの比較処理を行わない
		if(cowLine_copy.size() == 0) return 1;
		
		// 残った要素で再度比較する
		int comp = compFirstToTail(cowLine_copy);
		if(comp == 0)      return compSecondToSecondFromBehind(cowLine_copy);
		else if(comp == 1) return 1;
		else               return -1;
	}

	/** 
	 * 並び替え前後のリストを表示
	 */
	public static void displayResult() {
		System.out.print("Old : ");
		for(int i = 0; i < numberOfCow; i++)
			System.out.print(cowLine[i]);
		
		System.out.println("");
		
		System.out.print("New : ");
		for(char cow : arrayNewCowLine)
			System.out.print(cow);
	}
}
