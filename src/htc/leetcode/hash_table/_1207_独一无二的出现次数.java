package htc.leetcode.hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * AC
 * https://leetcode-cn.com/problems/unique-number-of-occurrences
 */
public class _1207_��һ�޶��ĳ��ִ��� {
	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(1, 2, 2, 1, 1, 3));
		System.out.println(uniqueOccurrences(1, 2));
		System.out.println(uniqueOccurrences(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0));
	}

	public static boolean uniqueOccurrences(int... arr) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int a : arr) {
			//ͳ��ÿ�����ֳ����˼���
			countMap.put(a, countMap.getOrDefault(a, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		//setͳ��value�Ƿ��ظ�����
		for (Integer val : countMap.values()) {
			if (!set.add(val)) {
				return false;
			}
		}
		return true;
	}
}
