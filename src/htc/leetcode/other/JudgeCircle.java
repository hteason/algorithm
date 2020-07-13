package htc.leetcode.other;

//657. 机器人能否返回原点

public class JudgeCircle {
	public static void main(String[] args) {
		System.out.println(judgeCircle("LL"));
	}

	public static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (char c : moves.toCharArray()) {
			switch (c) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'L':
				x--;
				break;
			case 'R':
				x++;
				break;
			default:
				break;
			}
		}
		return x == 0 && y == 0;
	}

	public static boolean judgeCircle2(String moves) {
		int[] move = new int[90];
		for (char c : moves.toCharArray()) {
			move[c]++;
		}
		return move['U']==move['D'] && move['L'] == move['R'];
	}
}
