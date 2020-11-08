package htc.leetcode.everyday._2020._07;

import java.util.Arrays;

/**
 * !AC
 */
public class _2020_07_09_ÃæÊÔÌâ_17_13_»Ö¸´¿Õ¸ñ {
    public static void main(String[] args) {
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
        System.out.println(respace(new String[]{}, "jesslookedjustliketimherbrother"));
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"}, ""));
    }

    public static int respace(String[] dictionary, String sentence) {
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }
        if (sentence.length() == 0) {
            return 0;
        }
        Arrays.sort(dictionary, (o1, o2) -> o2.length() - o1.length());
        for (String word : dictionary) {
            sentence = sentence.replaceAll(word, "");
        }
        return sentence.length();
    }
}
