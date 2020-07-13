package htc.leetcode.top_interview;

/*
 * status:AC
 * TODO �Ż�ʱ��
 * https://leetcode-cn.com/problems/valid-palindrome
 */
public class _125_��֤���Ĵ� {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("raca a car"));
		System.out.println(isPalindrome(";;121"));
		System.out.println(isPalindrome(".,10��"));
		System.out.println(isPalindrome("\"Sue,\" Tom smiles, \"Selim smote us.\""));
	}

	public static boolean isPalindrome(String s) {
		if ("".equals(s.trim())) {
			return true;
		}
		char[] cs = s.toLowerCase().toCharArray();
		int left = 0;
		int right = cs.length - 1;
		while (left < right) {
			while (left < cs.length && !Character.isAlphabetic(cs[left]) && !Character.isDigit(cs[left])) {
				left++;
			}
			if (left >= right) {
				return true;
			}
			while (right >= 0 && !Character.isAlphabetic(cs[right]) && !Character.isDigit(cs[right])) {
				right--;
			}
			if (left > right) {
				return false;
			}
			if (cs[left++] != cs[right--]) {
				return false;
			}

		}

		return true;
	}
}
