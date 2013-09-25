package procon;

public class ProCon013 {
	static int n   = 3;
	static int[] a = new int[] {3, 5, 8};
	static int[] m = new int[] {3, 2, 2};
	static int K   = 17;

	public static void main(String[] args) {
		// 結果表示
		System.out.println(run());
	}

	private static String run() {
		if (getResult(0, 0)) {
			return "Yes";
		}
		else {
			return "No";
		}
	}

	private static boolean getResult(int sum, int index) {
		if (index == n) {
			return false;
		}
		
		for (int i = 0; i < m[index] + 1; i++) {
			sum += a[index] * i;
			
			if (sum == K) {
				return true;
			}
			else if (sum > K || !getResult(sum, index + 1)) {
				sum -= a[index] * i;
			}
			else {
				return true;
			}
		}
		
		return false;
	}
}