package procon;

import java.util.Arrays;

public class ProCon008 {
	static int N    = 3;
	static int[] li = new int[]{8, 5, 8};
	
	public static void main(String[] args) {
		int sum = 0;
		int result = 0;
		boolean flag = false;
		
		Arrays.sort(li);
		for(int el : li) {
			sum += el;
			if(flag) result += sum;
			flag = true;
		}
		System.out.println(result);
	}
}