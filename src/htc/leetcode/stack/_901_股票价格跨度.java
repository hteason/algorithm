package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/*
 * AC
 * https://leetcode-cn.com/problems/online-stock-span/
 */
public class _901_��Ʊ�۸��� {

	public static void main(String[] args) {
		StockSpanner S = new StockSpanner();
//		System.out.println(S.next(100)); // �����ò����� 1��
//		System.out.println(S.next(80)); // �����ò����� 1��
//		System.out.println(S.next(60)); // �����ò����� 1��
//		System.out.println(S.next(70));// �����ò����� 2��
//		System.out.println(S.next(60));// �����ò����� 1��
//		System.out.println(S.next(75)); // �����ò����� 4��
//		System.out.println(S.next(85)); // �����ò����� 6��

		System.out.println(S.next(31)); // �����ò����� 1��
		System.out.println(S.next(41));// �����ò����� 2��
		System.out.println(S.next(48));// �����ò����� 1��
		System.out.println(S.next(59)); // �����ò����� 4��
		System.out.println(S.next(79)); // �����ò����� 6��
	}

	/*
	 * ��Ծ����
	 */
	static class StockSpanner {
		List<Integer> list;
		List<Integer> stepList;

		public StockSpanner() {
			list = new ArrayList<>();
			stepList = new ArrayList<>();
		}

		public int next(int price) {
			if (list.size() == 0) {
				list.add(price);
				stepList.add(1);
				return 1;
			}

			int ans = 1;
			for (int day = list.size() - 1; day > -1;) {
				if (list.get(day) > price) {
					list.add(price);
					stepList.add(ans);
					return ans;
				}
				ans += stepList.get(day);
				day -= stepList.get(day);
			}
			list.add(price);
			stepList.add(ans);
			return ans;
		}
	}
}
