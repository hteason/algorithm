package htc.leetcode.everyday;

/**
 * AC
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * ����˼·�������������飬���Կ��ǵ����ֲ���
 */
public class _2020_07_22_��ָOffer11_��ת�������С���� {
    public static void main(String[] args) {
        _2020_07_22_��ָOffer11_��ת�������С���� test = new _2020_07_22_��ָOffer11_��ת�������С����();
        System.out.println(test.minArray(new int[]{1,3,5}));
        System.out.println(test.minArray(new int[]{3,4,5,1,2}));
        System.out.println(test.minArray(new int[]{2,2,2,0,1}));
        System.out.println(test.minArray(new int[]{0}));
        System.out.println(test.minArray(new int[]{1,3,5,-1}));
    }

    //�򵥽ⷨ
    public int minArray(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
