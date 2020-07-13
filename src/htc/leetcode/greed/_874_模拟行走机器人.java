package htc.leetcode.greed;

//��ת90��
//�� -> ��
//�� -> ��
//�� -> ��
//�� -> ��

//��ת90��
//�� -> ��
//�� -> ��
//�� -> ��
//�� -> ��
/*
 * ��
 */
public class _874_ģ�����߻����� {
	public static void main(String[] args) {
//		System.out.println(robotSim(new int[] { 4, -1, 3 }, new int[][] {}));
//		System.out.println(robotSim(new int[] { 4, -1, 4, -2, 4 },
//				new int[][] { { 4, -2 } }));
	}

	public static int robotSim(int[] commands, int[][] obstacles) {
		int x = 0;
		int y = 0;
		int[] turnLeft = { 2, 3, 1, 0 };
		int[] turnRight = { 3, 2, 0, 1 };
		int[] map = { 1, -1, -1, 1 };
		int forward = 0;//0-�� 1-�� 2-�� 3-��
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] == -2) {//��ת
				forward = turnLeft[forward];
			} else if (commands[i] == -1) {//��ת
				forward = turnRight[forward];
			} else {
				int step = commands[i];

				if (forward == 0 || forward == 1) {
					//�ж�y������ϰ�
					for (int j = 0; j < obstacles.length; j++) {
						if (obstacles[j][0] == x&&obstacles[j][1] >= y) {
							if (forward == 0 && obstacles[j][0] > 0) {
								step = obstacles[j][1]-1;
							} else if (forward == 1 && obstacles[j][0] < 0) {
								step = obstacles[j][1]+1;
							}
							break;
						}
					}
					//���¼Ӽ�y
					y += map[forward] * step;
				} else {
					//�ж�x������ϰ�
					for (int j = 0; j < obstacles.length; j++) {
						if (obstacles[j][1] == y&&obstacles[j][0] >= x) {
							if (forward == 3 && obstacles[j][0] > 0) {
								step = obstacles[j][0]-1;
							} else if (forward == 2 && obstacles[j][0] < 0) {
								step = obstacles[j][0]+1;
							}
							break;
						}
					}
					//���ҼӼ�x
					x += map[forward] * step;
				}
			}
		}
		return x * x + y * y;
	}

}
