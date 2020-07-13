package htc.leetcode.top_interview;

import java.util.HashMap;
import java.util.Map;

/*
 * status: AC
 * FIXME 优化
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class _13_罗马数字转整数 {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}

	public static int romanToInt(String s) {
		int digit = 0;
		Map<Character, Integer> roman = new HashMap<Character, Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);

		char[] cs = s.toCharArray();
		for (int i = cs.length - 1; i >= 0; i--) {
			digit += roman.get(cs[i]);
			if (i > 0) {
				if ((cs[i] == 'V' || cs[i] == 'X') && cs[i - 1] == 'I') {
					digit -= 1;
					i--;
				} else if ((cs[i] == 'L' || cs[i] == 'C') && cs[i - 1] == 'X') {
					digit -= 10;
					i--;
				} else if ((cs[i] == 'D' || cs[i] == 'M') && cs[i - 1] == 'C') {
					digit -= 100;
					i--;
				}
			}
		}

		return digit;
	}
}
