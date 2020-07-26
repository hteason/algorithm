package htc.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * ��Ŀ: https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 * ���: https://leetcode-cn.com/problems/build-an-array-with-stack-operations/solution/javayi-ci-bian-li-jian-dan-yi-dong-by-hteason/
 */
public class _1441_��ջ������������ {
    public static void main(String[] args) {
        _1441_��ջ������������ test = new _1441_��ջ������������();
        System.out.println(test.buildArray(new int[]{1, 3}, 3));
        System.out.println(test.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(test.buildArray(new int[]{1, 2}, 4));
        System.out.println(test.buildArray(new int[]{2, 3, 4}, 4));
        System.out.println(test.buildArray(new int[]{1, 2, 3, 4}, 1));
        System.out.println(test.buildArray(new int[]{3}, 1));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        //i��1������n,ͬʱ��ͷ��ʼ�Ա�targetԪ��
        // ��Ԫ��i��target����ʱֻ��¼push����,Ȼ��target�Ƶ���һԪ��
        // ��������Ԫ��,��push��pop
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i < target[j]) {
                //��iС��target��ǰֵʱ,������ǰԪ��,����¼push��pop
                list.add("Push");
                list.add("Pop");
            } else if (i == target[j]) {
                //��Ԫ��i��target����ʱ,��¼push����,����ʼ�Ƚ�target��һԪ��
                list.add("Push");
                j++;
            }
        }
        return list;
    }
}
