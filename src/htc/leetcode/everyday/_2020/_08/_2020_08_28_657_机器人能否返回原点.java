package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class _2020_08_28_657_机器人能否返回原点 {
    //统计上下、左右步数是否分别都相等，相等则会回到原位
    public boolean judgeCircle(String moves) {
        int[] move = new int[90];
        for (char c : moves.toCharArray()) {
            move[c]++;
        }
        return move['U'] == move['D'] && move['L'] == move['R'];

    }
}
