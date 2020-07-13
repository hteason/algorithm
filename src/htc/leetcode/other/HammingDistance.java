package htc.leetcode.other;

/**
 * 461. �������� ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
 * 
 * ������������ x �� y����������֮��ĺ������롣
 * 
 * ע�⣺ 0 �� x, y < 231.
 * 
 * ʾ��:
 * 
 * ����: x = 1, y = 4
 * 
 * ���: 2
 * 
 * ����: 1 (0 0 0 1) 4 (0 1 0 0) �� ��
 * 
 * ����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
 */
public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance3(3, 4));
		// 011
		// 100
	}

	// ��λ����
	public static int hammingDistance(int x, int y) {
		int count = 0;
		int bak = x > y ? x : y;
		for (int i = 0; bak != 0; i++) {
			if ((x & (1 << i)) != (y & (1 << i))) {
				count++;
			}
			bak &= ~(1 << i);
		}
		return count;
	}

	// ���ͳ��1�ĸ���
	public static int hammingDistance2(int x, int y) {
		int count = 0;
		int bak = x ^ y;
		while( bak != 0) {
			bak &= (bak - 1);
			count++;
		}
		return count;
	}
	// ����Integer���
	public static int hammingDistance3(int x, int y) {
		return Integer.bitCount(x^y);
	}
}
