package htc.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	
	public static void main(String[] args) {
		letterCasePermutation("C");
	}
	public static List<String> letterCasePermutation(String S) {
		List<String > ans = new ArrayList<>();
		dfs(S.toCharArray(),0,ans);
		return ans;
	}
	
	public static void dfs(char[] s,int step,List<String> ans) {
		if(step == s.length) {
			System.out.println(s);
			ans.add(new String(s));
			return;
		}
		
		dfs(s,step+1,ans);
		if(Character.isDigit(s[step])) {
			return;
		}
		
		s[step] ^= 32;

		dfs(s,step+1,ans);
		s[step] ^= 32;

	}
}
