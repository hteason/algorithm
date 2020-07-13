package htc.leetcode.lcof;

/*
 * AC
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 */
public class _05_Ìæ»»¿Õ¸ñ {
	public static void main(String[] args) {
		System.out.println(replaceSpace("We are happy."));
		System.out.println(replaceSpace("   "));
		System.out.println(replaceSpace(""));
	}

	public static String replaceSpace(String s) {
		char[] reChar = new char[s.length() * 3];
		int size = 0;
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				reChar[size++] = '%';
				reChar[size++] = '2';
				reChar[size++] = '0';
			} else {
				reChar[size++] = c;
			}
		}
		return new String(reChar, 0, size);
	}
}
