package htc.leetcode.other;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号 输入："(()())(())" 输出："()()()" 解释： 输入字符串为 "(()())(())"，原语化分解得到
 * "(()())" + "(())"， 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
public class RemoveOuterParentheses1021 {
	public static void main(String[] args) {
		//todo unfinish
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
	}

	public static String removeOuterParentheses(String S) {
		Stack<Character> stack = new Stack<>();
		Stack<Character> res = new Stack<>();
		for (Character c : S.toCharArray()) {
			
		}
		return res.toString();
	}
	
	//AC
	public static String removeOuterParentheses2(String S) {

        int l = 0;
        int r = 0;
        String res = "";
        for(char c: S.toCharArray()){
            if(l==r&&c=='('){
                l++;
            }
            else if(l==r+1&&c==')'){
                r++;
            }
            else if(l!=r&&c=='('){
                l++;
                res += "(";
            }
            else if(l!=r&&c==')'){
                r++;
                res += ")";
            }
        }
        return res;
	}
}
