package htc.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * 键盘如下图所示 输入: ["Hello", "Alaska", "Dad",
 * "Peace"] 输出: ["Alaska", "Dad"]
 *
 */
public class FindWords500 {

	public static void main(String[] args) {
		String[] words = { "Hello", "Alaska", "Dad", "Peace" };
		findWords(words);
	}

	static Map<Character, Integer> map = new HashMap<>();

	public static String[] findWords(String[] words) {
		List<String> res = new ArrayList<>();
		map.put('Q', 1);
		map.put('W', 1);
		map.put('E', 1);
		map.put('R', 1);
		map.put('T', 1);
		map.put('Y', 1);
		map.put('U', 1);
		map.put('I', 1);
		map.put('O', 1);
		map.put('P', 1);

		map.put('A', 2);
		map.put('S', 2);
		map.put('D', 2);
		map.put('F', 2);
		map.put('G', 2);
		map.put('H', 2);
		map.put('J', 2);
		map.put('K', 2);
		map.put('L', 2);

		map.put('Z', 3);
		map.put('X', 3);
		map.put('C', 3);
		map.put('V', 3);
		map.put('B', 3);
		map.put('N', 3);
		map.put('M', 3);

		for (int i = 0; i < words.length; i++) {
			int line = 0;
			boolean isALine = true;
			for (int j = 0; j < words[i].length(); j++) {
				Character ch = words[i].charAt(j);
				if (j == 0) {
					line = map.get(Character.toUpperCase(ch));
				} else if (map.get(Character.toUpperCase(ch)) != line) {
					isALine = false;
					break;
				}
			}
			if (isALine) {
				res.add(words[i]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
}
