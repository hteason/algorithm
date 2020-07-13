package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/*
 * AC
 * https://leetcode-cn.com/problems/online-stock-span/
 */
public class _901_股票价格跨度 {

	public static void main(String[] args) {
		StockSpanner S = new StockSpanner();
//		System.out.println(S.next(100)); // 被调用并返回 1，
//		System.out.println(S.next(80)); // 被调用并返回 1，
//		System.out.println(S.next(60)); // 被调用并返回 1，
//		System.out.println(S.next(70));// 被调用并返回 2，
//		System.out.println(S.next(60));// 被调用并返回 1，
//		System.out.println(S.next(75)); // 被调用并返回 4，
//		System.out.println(S.next(85)); // 被调用并返回 6。

		System.out.println(S.next(31)); // 被调用并返回 1，
		System.out.println(S.next(41));// 被调用并返回 2，
		System.out.println(S.next(48));// 被调用并返回 1，
		System.out.println(S.next(59)); // 被调用并返回 4，
		System.out.println(S.next(79)); // 被调用并返回 6。
	}

	/*
	 * 跳跃检索
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
