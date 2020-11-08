package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class _2020_08_23_201_���ַ�Χ��λ�� {
    public static void main(String[] args) {
        _2020_08_23_201_���ַ�Χ��λ�� test = new _2020_08_23_201_���ַ�Χ��λ��();
        System.out.println(test.rangeBitwiseAnd(1, 4));
        System.out.println(test.rangeBitwiseAnd(5, 7));
        System.out.println(test.rangeBitwiseAnd(0, 1));
        System.out.println(test.rangeBitwiseAnd(2, 2));
        System.out.println(test.rangeBitwiseAnd(2, 3));
        System.out.println(test.rangeBitwiseAnd(4, 5));
        System.out.println(test.rangeBitwiseAnd(12, 14));
        System.out.println(test.rangeBitwiseAnd(0, 2147483647));
        System.out.println(test.rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(test.rangeBitwiseAnd(2147483247, 2147483647));
        System.out.println(test.rangeBitwiseAnd(600000000, 2147483645));
        System.out.println(test.rangeBitwiseAnd(536870912, 1073741823));
        System.out.println(test.rangeBitwiseAnd(1073741925, 2147483646));
    }

    public int rangeBitwiseAnd(int m, int n) {
        //������ͬ��������������֮���Ǳ���
        if (m == n) {
            return m;
        }
        //�ж�n��m�Ƿ���ͬһ��2���ݷ�Χ��,���ǵĻ�����϶���0,��Ϊ�м侭�������б���λ����һ�������
        for (int i = 0; i < 31; i++) {
            int num = 2 << i;
            if (m < num) {
                if (n >= num) {
                    return 0;
                } else {
                    break;
                }
            }
        }
        /*
        n m��ͬ��2���ݷ�Χ��
        1. �Զ��������Ӻ���ǰ��ÿһλ����,�������һ������ȵ���(��һ����0һ����1�����)
        2. �����һ������ȵ��������֮���������0,�ٰ�֮ǰ��01��ת��Ϊʮ����,��Ϊ���

        ��:n=10 m=12, ʮ���Ʒֱ�Ϊ1010��1100
        1. �Ӻ���ǰ����������,���һ������ȵ���λ���±�1,��1[0]10��1[1]00
        2. ���±�1����ͺ����������0,�±�1֮ǰ��������,��1000,תΪʮ���Ƶ�8
         */
        int ans = 0;
        for (int pow = 1; m != 0; pow <<= 1) {
            int mb = m & 1;
            int nb = n & 1;
            if (mb != nb) {
                ans = 0;
            } else if (mb == 1) {
                ans += pow;
            }
            m >>= 1;
            n >>= 1;
        }
        return ans;
    }
}
