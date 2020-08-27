package htc.leetcode.everyday;

public class _459_重复的子字符串 {
    public static void main(String[] args) {
        _459_重复的子字符串 test = new _459_重复的子字符串();
        System.out.println(test.repeatedSubstringPattern("abab"));
        System.out.println(test.repeatedSubstringPattern("aba"));
        System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {

        char[] cs = s.toCharArray();
//        for (int i = 0; i < cs.length; i++) {
//            String sub = s.substring(0, i);
//            String res = s.replaceAll(sub, "");
//            if ("".equals(res)) {
//                return true;
//            }
//        }
//        return false;

        int begin = 0;
        while (begin < cs.length) {
            int index = findNext(cs, begin);
            if (index == -1) {
                return false;
            }
            begin = index + 1;
            for (int i = 0, j = index; i < cs.length && i < index; i++, j++) {
                if (cs[i] != cs[j]) {
                    break;
                }
            }
        }
        return false;
    }

    private int findNext(char[] cs, int begin) {
        char c = cs[0];
        for (int i = begin; i < cs.length; i++) {
            if (c == cs[i]) {
                return i;
            }
        }
        return -1;
    }
}
