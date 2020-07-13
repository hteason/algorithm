package htc.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * AC
 * TODO �Ż�
 * https://leetcode-cn.com/problems/asteroid-collision
 */
public class _735_������ײ {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(5, 10, -5, -10)));// 5
		System.out.println(Arrays.toString(asteroidCollision(8, -8, -9, 9)));// -9,9
		System.out.println(Arrays.toString(asteroidCollision(10, 2, -5)));// 10
		System.out.println(Arrays.toString(asteroidCollision(-2, -1, 1, 2)));// -2, -1, 1, 2
		System.out.println(Arrays.toString(asteroidCollision(-2, -2, 1, -2)));// -2,-2,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, -2, 2, -2)));// -2,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, -1, 1, -2)));// -2,-1,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, 1, 1, -2)));// -2,-2
		System.out.println(Arrays.toString(asteroidCollision(1, -2, -2, -2)));// -2��-2��-2
	}

	// ����ʵ�֣����Ա�Stack��7���� 4ms 40.2 MB 89.82% 29.72%
	// ���Ż� 3ms 39.7MB 94.91% 48.86%
	public static int[] asteroidCollision(int... asteroids) {
		int[] stack = new int[asteroids.length];
		int index = 0;
		for (int x : asteroids) {
			if (index == 0 || (stack[index - 1] < 0 && x < 0)
					|| (stack[index - 1] > 0 && x > 0/* ||(stack[index - 1] < 0 && x > 0) */)) {
				stack[index++] = x;
			} else {
				while (index != 0) {
					if (stack[index - 1] > 0 && stack[index - 1] < -x) {
						// pop�˼�����peek
						index--;
						if (index == 0) {
							stack[index++] = x;
							break;
						}
					} else if (stack[index - 1] > 0 && stack[index - 1] == -x) {
						// ͬ���ھ�,pop,��push
						index--;
						break;
					} else if (stack[index - 1] > 0 && stack[index - 1] > -x) {
						// ��push
						break;
					} else {
						stack[index++] = x;
						break;
					}
				}

			}
		}
		return Arrays.copyOfRange(stack, 0, index);
	}

	/*
	 * ��̫���ˣ�����AC��������ô���� 28ms 41.9 MB 14.38% 6.29%
	 */
	public static int[] asteroidCollision_stack(int... asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int x : asteroids) {
			if (stack.isEmpty() || (stack.peek() < 0 && x > 0) || (stack.peek() < 0 && x < 0)
					|| (stack.peek() > 0 && x > 0)) {
				stack.push(x);
			} else {
				while (!stack.isEmpty()) {
					if (stack.peek() > 0 && stack.peek() < -x) {
						// pop�˼�����peek
						stack.pop();
						if (stack.isEmpty()) {
							stack.push(x);
							break;
						}
					} else if (stack.peek() > 0 && stack.peek() == -x) {
						// ͬ���ھ�,pop,��push
						stack.pop();
						break;
					} else if (stack.peek() > 0 && stack.peek() > -x) {
						// ��push
						break;
					} else {
						stack.push(x);
						break;
					}
				}

			}
		}

		int[] ans = new int[stack.size()];
		for (int i = stack.size() - 1; !stack.isEmpty(); i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}
}
