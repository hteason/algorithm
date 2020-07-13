package htc.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * AC
 * TODO 优化
 * https://leetcode-cn.com/problems/asteroid-collision
 */
public class _735_行星碰撞 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(5, 10, -5, -10)));// 5
		System.out.println(Arrays.toString(asteroidCollision(8, -8, -9, 9)));// -9,9
		System.out.println(Arrays.toString(asteroidCollision(10, 2, -5)));// 10
		System.out.println(Arrays.toString(asteroidCollision(-2, -1, 1, 2)));// -2, -1, 1, 2
		System.out.println(Arrays.toString(asteroidCollision(-2, -2, 1, -2)));// -2,-2,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, -2, 2, -2)));// -2,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, -1, 1, -2)));// -2,-1,-2
		System.out.println(Arrays.toString(asteroidCollision(-2, 1, 1, -2)));// -2,-2
		System.out.println(Arrays.toString(asteroidCollision(1, -2, -2, -2)));// -2，-2，-2
	}

	// 数组实现（明显比Stack快7倍） 4ms 40.2 MB 89.82% 29.72%
	// 再优化 3ms 39.7MB 94.91% 48.86%
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
						// pop了继续比peek
						index--;
						if (index == 0) {
							stack[index++] = x;
							break;
						}
					} else if (stack[index - 1] > 0 && stack[index - 1] == -x) {
						// 同归于尽,pop,不push
						index--;
						break;
					} else if (stack[index - 1] > 0 && stack[index - 1] > -x) {
						// 不push
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
	 * 我太难了，终于AC！明明这么容易 28ms 41.9 MB 14.38% 6.29%
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
						// pop了继续比peek
						stack.pop();
						if (stack.isEmpty()) {
							stack.push(x);
							break;
						}
					} else if (stack.peek() > 0 && stack.peek() == -x) {
						// 同归于尽,pop,不push
						stack.pop();
						break;
					} else if (stack.peek() > 0 && stack.peek() > -x) {
						// 不push
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
