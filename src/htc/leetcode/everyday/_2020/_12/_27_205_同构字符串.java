package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @date 2020/12/27
 */
public class _27_205_同构字符串 {
    public static void main(String[] args) {
        _27_205_同构字符串 test = new _27_205_同构字符串();
        System.out.println(test.isIsomorphic("egg", "add"));
        System.out.println(test.isIsomorphic("foo", "bar"));
        System.out.println(test.isIsomorphic("paper", "title"));
        System.out.println(test.isIsomorphic("", ""));
        System.out.println(test.isIsomorphic("ae", "zr"));
        System.out.println(test.isIsomorphic("aea", "abc"));
        System.out.println(test.isIsomorphic("ab", "aa"));
        System.out.println(test.isIsomorphic("13", "42"));
        System.out.println(test.isIsomorphic("ZA", "EA"));
        System.out.println(test.isIsomorphic("~~", "}~"));
    }

    //AC 第一版
    public boolean isIsomorphic1(String s, String t) {
        int[] map = new int[128];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (map[ss[i]] != 0) {
                if (map[ss[i]] != ts[i]) {
                    return false;
                }
            } else {
                map[ss[i]] = ts[i];
            }
        }
        map = new int[128];
        for (int i = 0; i < ts.length; i++) {
            if (map[ts[i]] != 0) {
                if (map[ts[i]] != ss[i]) {
                    return false;
                }
            } else {
                map[ts[i]] = ss[i];
            }
        }
        return true;
    }

    //AC 第二版 牺牲时间提升空间
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (map1[ss[i]] != 0) {
                if (map1[ss[i]] != ts[i]) {
                    return false;
                }
            } else {
                map1[ss[i]] = ts[i];
            }

            if (map2[ts[i]] != 0) {
                if (map2[ts[i]] != ss[i]) {
                    return false;
                }
            } else {
                map2[ts[i]] = ss[i];
            }
        }
        return true;
    }
}
