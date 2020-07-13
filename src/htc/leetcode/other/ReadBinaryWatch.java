package htc.leetcode.other;

import java.util.ArrayList;
import java.util.List;
/**
 * 01÷”±Ì
 * 
 * @author HuangTingCheng
 *
 */
public class ReadBinaryWatch {
	public static void main(String[] args) {
		readBinaryWatch(2);
	}

	public static List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		int[] index = new int[10];
		dfs(0, num, res, index, 0);
		return res;
	}

	public static void dfs(int step, int num, List<String> res, int[] index, int limit) {
		if (step == 10) {
			if (limit == num) {
//				System.out.println(Arrays.toString(index));
				int h = 0, m = 0;
				for (int i = 10; i >= 0; i--) {// h
					if (i < 4 && index[i] == 1) {
						h += Math.pow(2, 3 - i);
					} else if (i < 10 && index[i] == 1) {
						m += Math.pow(2, 9 - i);
					}
				}
				if (h < 11 && m<60) {
					res.add(h + ":" + (m < 10 ? ("0" + m) : m));
					System.out.println(h + ":" + (m < 10 ? ("0" + m) : m));
				}
			}
			return;
		} else {
			for (int j = 0; j < 2; j++) {
				index[step] = j;
				dfs(step + 1, num, res, index, limit + j);
				index[step] = j;
			}
		}
	}
}
