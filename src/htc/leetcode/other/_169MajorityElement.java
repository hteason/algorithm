package htc.leetcode.other;

import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println("-----------");
		System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			int val = map.getOrDefault(i, 0) + 1;
			if (val > nums.length / 2) {
				return i;
			}
			map.put(i, val);
		}
		return 0;
	}
}
