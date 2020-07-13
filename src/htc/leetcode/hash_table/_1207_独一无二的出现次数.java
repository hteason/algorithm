package htc.leetcode.hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * AC
 * https://leetcode-cn.com/problems/unique-number-of-occurrences
 */
public class _1207_独一无二的出现次数 {
	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(1, 2, 2, 1, 1, 3));
		System.out.println(uniqueOccurrences(1, 2));
		System.out.println(uniqueOccurrences(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0));
	}

	public static boolean uniqueOccurrences(int... arr) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int a : arr) {
			//统计每个数字出现了几次
			countMap.put(a, countMap.getOrDefault(a, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		//set统计value是否重复出现
		for (Integer val : countMap.values()) {
			if (!set.add(val)) {
				return false;
			}
		}
		return true;
	}
}
