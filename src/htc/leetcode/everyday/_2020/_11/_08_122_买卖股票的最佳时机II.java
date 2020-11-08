package htc.leetcode.everyday._2020._11;

/**
 * AC
 * ���Ż�Ϊÿ�춼�������������󣬽�������������
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class _08_122_������Ʊ�����ʱ��II {
    public static void main(String[] args) {
        _08_122_������Ʊ�����ʱ��II test = new _08_122_������Ʊ�����ʱ��II();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(test.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * ��һ��ļ۸�Ƚ���࣬�����֮ǰ��¼����Сֵ
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int total = 0;
        int price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i - 1];
            int next = prices[i];
            if (cur > next) {
                total += cur - price;
                price = next;
            } else if (i == prices.length - 1 && next > price) {
                total += next - price;
            }
        }
        return total;
    }
}
