package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class _2020_08_28_657_�������ܷ񷵻�ԭ�� {
    //ͳ�����¡����Ҳ����Ƿ�ֱ���ȣ�������ص�ԭλ
    public boolean judgeCircle(String moves) {
        int[] move = new int[90];
        for (char c : moves.toCharArray()) {
            move[c]++;
        }
        return move['U'] == move['D'] && move['L'] == move['R'];

    }
}
