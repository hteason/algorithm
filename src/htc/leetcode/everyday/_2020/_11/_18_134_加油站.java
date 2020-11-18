package htc.leetcode.everyday._2020._11;

/**
 * AC
 * 用时过长，可用贪心优化
 * https://leetcode-cn.com/problems/gas-station/
 */
public class _18_134_加油站 {
    public static void main(String[] args) {
        _18_134_加油站 test = new _18_134_加油站();
        System.out.println(test.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(test.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(test.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 2, 3}));
    }

    //环式遍历解法
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int total = gas[i] - cost[i];
                int j = 0;
                for (int k = (i + 1) % len; j < gas.length; j++, k = (++k) % len) {
                    total += gas[k];
                    if (total < cost[k]) {
                        break;
                    }
                    total -= cost[k];
                }
                if (j == len) {
                    return i;
                }
            }
        }
        return -1;
    }
}
