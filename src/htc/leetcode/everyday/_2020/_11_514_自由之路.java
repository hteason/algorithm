package htc.leetcode.everyday._2020;

/**
 * @author huangtingcheng
 * @date 2020/11/11
 */
public class _11_514_自由之路 {
    public static void main(String[] args) {
        _11_514_自由之路 test = new _11_514_自由之路();
        System.out.println(test.findRotateSteps("godding","gd"));
        System.out.println(test.findRotateSteps("godding","goi"));
    }

    public int findRotateSteps(String ring, String key) {
        int ans = 0;
        char[] cs = ring.toCharArray();
        char[] ks = key.toCharArray();
        int cur = 0;
        for (char k : ks) {
            for (int i = 0; i < cs.length; i++) {
                
            }
        }

        return ans;
    }
}
