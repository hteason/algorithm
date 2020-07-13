package htc.leetcode.other;
/**
 * 476. ���ֵĲ���
����һ����������������Ĳ����������ǶԸ����Ķ����Ʊ�ʾȡ����

ע��:

������������֤��32λ�����������ķ�Χ�ڡ�
����Լٶ���������������ǰ����λ��
ʾ�� 1:

����: 5
���: 2
����: 5�Ķ����Ʊ�ʾΪ101��û��ǰ����λ�����䲹��Ϊ010����������Ҫ���2��
ʾ�� 2:

����: 1
���: 0
����: 1�Ķ����Ʊ�ʾΪ1��û��ǰ����λ�����䲹��Ϊ0����������Ҫ���0��
 * @author HuangTingCheng
 *
 */
public class FindComplement {
	public static void main(String[] args) {
		System.out.println(findComplement3(5));// 
	}

	public static int findComplement(int num) {
		int tmp = num;
		for (int i = 0; tmp != 0; i++) {
			num = num ^ (1 << i);
			tmp &= (tmp - 1);
		}
		return num;
	}

	// TODO unfinished
	public static int findComplement2(int num) {
		int tmp = num;
		for (int i = 0; tmp != 0; i++) {
			num = (num & (1 << i)) == 1 ? num & (~(1 << i)) : num | (1 << i);
			tmp &= ~(1 << i);
		}
		return num;
	}

	// other ����tempͳ��λ����λ������cÿλ����Ϊ1������num��� 
	//	101^111 -> 010
	public static int findComplement3(int num) {
		int temp = num, c = 0;
		while (temp > 0) {
			temp >>= 1;
			c = (c << 1) + 1;
		}
		return num ^ c;
	}
}
