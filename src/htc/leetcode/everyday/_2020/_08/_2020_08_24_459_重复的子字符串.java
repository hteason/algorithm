package htc.leetcode.everyday._2020._08;

/**
 * AC
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class _2020_08_24_459_�ظ������ַ��� {
    public static void main(String[] args) {
        _2020_08_24_459_�ظ������ַ��� test = new _2020_08_24_459_�ظ������ַ���();
        System.out.println(test.repeatedSubstringPattern("abab"));
        System.out.println(test.repeatedSubstringPattern("aba"));
        System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(test.repeatedSubstringPattern("aaaa"));
        System.out.println(test.repeatedSubstringPattern("abababa"));
        System.out.println(test.repeatedSubstringPattern("abababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sub = new StringBuilder();
        for (int i = 0, len = cs.length; i < len / 2; i++) {
            sub.append(cs[i]);
            int subLen = sub.length();
            //ԭ���ǵ�ǰ�Ӵ��ı����Ż�������ظ��Ӵ���������
            if (subLen != 0 && len % subLen == 0) {
                int j = subLen;
                //��ǰ�Ӵ���һ�ԱȺ�����Ӵ�,���ܱȵ����,�ض����ظ��Ӵ�
                for (; j < len; j += subLen) {
                    //ÿ�β���Ϊ�Ӵ�����
                    if (!sub.toString().equals(s.substring(j, j + subLen))) {
                        break;
                    }
                }
                if (j == len) {
                    return true;
                }
            }
        }
        return false;
    }

    //����,��ʱ
    public boolean repeatedSubstringPattern2(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            String sub = s.substring(0, i);
            String res = s.replaceAll(sub, "");
            if ("".equals(res)) {
                return true;
            }
        }
        return false;
    }
}
