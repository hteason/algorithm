package htc.leetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 944. ɾ������
 * 
 * ������ N ��Сд��ĸ�ַ�����ɵ����� A������ÿ���ַ���������ȡ�
 * 
 * ѡȡһ��ɾ���������У����� A �е�ÿ���ַ�����ɾ����Ӧÿ�����������ַ��� �����µ��ַ����д������¶��γ��С�
 * 
 * ���磬�� A = ["abcdef", "uvwxyz"]��ɾ���������� {0, 2, 3}��ɾ���� A Ϊ["bef", "vyz"]�� A
 * ���зֱ�Ϊ["b","v"], ["e","y"], ["f","z"]������ʽ�ϣ��� n ��Ϊ [A[0][n], A[1][n], ...,
 * A[A.length-1][n]]����
 * 
 * ���裬����ѡ����һ��ɾ������ D����ô��ִ��ɾ������֮��A ����ʣ���ÿһ�ж������� �ǽ��� ���еģ�Ȼ�����㷵�� D.length ����С����ֵ��
 * 
 * ʾ�� 1��
 * 
 * ���룺["cba", "daf", "ghi"] �����1 ���ͣ� ��ѡ�� D = {1}��ɾ���� A ����Ϊ��["c","d","g"] ��
 * ["a","f","i"]����Ϊ�ǽ������С� ��ѡ�� D = {}����ô A ���� ["b","a","h"] �Ͳ��Ƿǽ��������ˡ�
 * 
 * @author HuangTingCheng
 *
 */
public class MinDeletionSize {
	public static void main(String[] args) {
		System.out.println(minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
	}

	public static int minDeletionSize(String[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length - 1; i++) {
			String s1 = A[i];
			String s2 = A[i + 1];
			for (int j = 0; j < s1.length(); j++) {
				if (!set.contains(j) && s1.charAt(j) > s2.charAt(j)) {
					set.add(j);
				}
			}
		}
		return set.size();
	}
}
