package htc.leetcode.other;
/*
 * AC
 * https://leetcode-cn.com/problems/guess-numbers
 */
public class LCP_1_²ÂÊý×Ö {
	public static void main(String[] args) {
		System.out.println(game(new int[] {1,2,3}, new int[]{1,2,3}));
		System.out.println(game(new int[] {2,2,3}, new int[]{3,2,1}));
	}

	public static int game(int[] guess, int[] answer) {
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			if (guess[i]==answer[i]) {
				ans++;
			}
		}
		return ans;
	}
}
