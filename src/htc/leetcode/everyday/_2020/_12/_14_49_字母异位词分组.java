package htc.leetcode.everyday._2020._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AC
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @date 2020/12/14
 */
public class _14_49_字母异位词分组 {
    public static void main(String[] args) {
        _14_49_字母异位词分组 test = new _14_49_字母异位词分组();
        System.out.println(test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(test.groupAnagrams(new String[]{"eat"}));
        System.out.println(test.groupAnagrams(new String[]{}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Stream.of(strs).collect(Collectors.groupingBy(x -> {
            char[] cs = x.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        })).forEach((k, v) -> ans.add(v));
        return ans;
    }
}
