package htc.leetcode.other;

import java.util.ArrayList;
import java.util.List;

import htc.leetcode.datatype.CustomFunction;

/*
 * ���Թ���
 * AC
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation
 */
public class _1237_�ҳ��������̵��������� {

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = z; i/2 >= 1; i--) {
			for (int j = 1; j <= z; j++) {
				if (customfunction.f(j, i) == z) {
					List<Integer> in = new ArrayList<Integer>(2);
					in.add(j);
					in.add(i);
					ans.add(in);
				}
			}
		}
		return ans;
	}
}
