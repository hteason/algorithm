package htc.leetcode.stack;

import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/simplify-path
 */
public class _71_简化路径 {
	public static void main(String[] args) {
		int TODO;// 优化时间，分割/为字符串数组！
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/home//foo../"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/a/../../b/../c//.//"));
		System.out.println(simplifyPath("/..a//b////c/d//././/.."));
		System.out.println(simplifyPath("/."));
		System.out.println(simplifyPath("/.."));
		System.out.println(simplifyPath("/..."));
		System.out.println(simplifyPath("/.../"));
		System.out.println(simplifyPath("/..../"));
		System.out.println(simplifyPath("/home/of/foo/../../bar/../../is/./here/."));
	}

	/*
	 * /开头： /./ 跳过 /../ 上一级目录
	 * 
	 */
	// 苦命AC，我觉得我也看不懂自己的代码了：11ms 36.1MB 16.21% 89.38%
	public static String simplifyPath(String path) {
		// 三种情况判断：. / 非.非/

		// 1： .后面可能出现一个/[.不入栈，且跳过/] ;出现./[上一目录出栈,pop直到/]

		// 2： /后面可能出现字母->[入栈]；出现/ -> [跳过到下一个];/是最后一个字符，不入栈

		// 3： 非.非/ -> 入栈

		Stack<Character> stack = new Stack<>();
		char[] ch = path.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '.':
				// 出现'/.'结尾的情况，不push('.')
				if (i + 1 != ch.length || (!stack.isEmpty() && stack.peek() != '/')) {
					stack.push(ch[i]);
				}
				break;
			case '/':
				if (i + 2 < ch.length && ch[i + 1] == '.' && ch[i + 2] == '/') {
					// // '/./'同时出现，i+=1跳到/./的后一个/
					i += 1;
				} else if ((i + 3 < ch.length && ch[i + 1] == '.' && ch[i + 2] == '.' && ch[i + 3] == '/')
						|| (i + 3 == ch.length && ch[i + 1] == '.' && ch[i + 2] == '.')) {
					// '/../'
					i += 2;// i+=2跳到/../的后一个/
					// 上一目录出栈
					if (stack.size() > 1 && stack.peek() == '/') {
						// 当栈里只有'/'时不出栈(保留根目录)
						stack.pop();// 将'/'出栈
					}
					while (!stack.isEmpty() && stack.peek() != '/') {// 目录出栈，直到遇到'/'
						stack.pop();
					}
				}
				if (stack.isEmpty() || stack.peek() != '/') {// 上一个不是'/'才入栈
					stack.push('/');
				}
				break;
			default:
				stack.push(ch[i]);
				break;
			}
		}

		if (!stack.isEmpty() && stack.peek() == '/') {
			stack.pop();
		}

		if (stack.isEmpty()) {
			return "/";
		}
		StringBuilder ans = new StringBuilder(stack.size());
		for (int i = 0, size = stack.size(); i < size; i++) {
			ans.append(stack.get(i));
		}
		return ans.toString();
	}
}
