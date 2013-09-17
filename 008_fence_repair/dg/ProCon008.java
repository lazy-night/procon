package procon;

import java.util.ArrayList;
import java.util.Collections;

public class ProCon008 {
	static int N    = 3;
	static int[] li = new int[]{8, 5, 8};
	static ArrayList<Integer> arrayLi = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int sum = 0;
		
		// 要素の詰め替え
		for(int el : li) arrayLi.add(el);
		while (arrayLi.size() != 1) {
			Collections.sort(arrayLi);
			
			// 1,2番目に小さい数を加算して合計値に加える
			int p1 = arrayLi.remove(0);
			int p2 = arrayLi.remove(0);
			sum = sum + p1 + p2;
			// 上記の和を元のリストに詰める
			arrayLi.add(p1 + p2);
		}
		
		System.out.println(sum);
	}
}