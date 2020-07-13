package htc.leetcode.stack;

import java.util.Stack;

/*
 * AC
 * https://leetcode-cn.com/problems/simplify-path
 */
public class _71_��·�� {
	public static void main(String[] args) {
		int TODO;// �Ż�ʱ�䣬�ָ�/Ϊ�ַ������飡
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
	 * /��ͷ�� /./ ���� /../ ��һ��Ŀ¼
	 * 
	 */
	// ����AC���Ҿ�����Ҳ�������Լ��Ĵ����ˣ�11ms 36.1MB 16.21% 89.38%
	public static String simplifyPath(String path) {
		// ��������жϣ�. / ��.��/

		// 1�� .������ܳ���һ��/[.����ջ��������/] ;����./[��һĿ¼��ջ,popֱ��/]

		// 2�� /������ܳ�����ĸ->[��ջ]������/ -> [��������һ��];/�����һ���ַ�������ջ

		// 3�� ��.��/ -> ��ջ

		Stack<Character> stack = new Stack<>();
		char[] ch = path.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case '.':
				// ����'/.'��β���������push('.')
				if (i + 1 != ch.length || (!stack.isEmpty() && stack.peek() != '/')) {
					stack.push(ch[i]);
				}
				break;
			case '/':
				if (i + 2 < ch.length && ch[i + 1] == '.' && ch[i + 2] == '/') {
					// // '/./'ͬʱ���֣�i+=1����/./�ĺ�һ��/
					i += 1;
				} else if ((i + 3 < ch.length && ch[i + 1] == '.' && ch[i + 2] == '.' && ch[i + 3] == '/')
						|| (i + 3 == ch.length && ch[i + 1] == '.' && ch[i + 2] == '.')) {
					// '/../'
					i += 2;// i+=2����/../�ĺ�һ��/
					// ��һĿ¼��ջ
					if (stack.size() > 1 && stack.peek() == '/') {
						// ��ջ��ֻ��'/'ʱ����ջ(������Ŀ¼)
						stack.pop();// ��'/'��ջ
					}
					while (!stack.isEmpty() && stack.peek() != '/') {// Ŀ¼��ջ��ֱ������'/'
						stack.pop();
					}
				}
				if (stack.isEmpty() || stack.peek() != '/') {// ��һ������'/'����ջ
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
