package htc.leetcode.everyday._2020._11;

/**
 * AC
 * 桶计数
 * https://leetcode-cn.com/problems/valid-anagram/
 * @date 2020/11/22
 */
public class _22_242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int slen = s.length();
        int[] ss = new int[26];
        int[] ts = new int[26];
        for(int i = 0; i < slen; i++){
            ss[s.charAt(i) - 'a']++;
            ts[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(ss[i] != ts[i]){
                return false;
            }
        }
        return true;
    }
}
