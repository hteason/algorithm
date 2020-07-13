package htc.leetcode.other;

public class _1309_解码字母到整数映射 {
	public static void main(String[] args) {
		System.out.println(freqAlphabets("10#11#12"));
		System.out.println(freqAlphabets("1326#"));
		System.out.println(freqAlphabets("25#"));
		System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
	}

	public static String freqAlphabets(String s) {
		char[] cs = s.toCharArray();
		StringBuilder sb = new StringBuilder(cs.length);
		for (int i = 0; i < cs.length; i++) {
			if (i + 2 < cs.length && cs[i + 2] == '#') {
				sb.append((char) (cs[i] * 10 + cs[i + 1] - 432));
				i += 2;
			} else {
				sb.append((char) (cs[i] + 48));
			}
		}
		return sb.toString();
	}
}
