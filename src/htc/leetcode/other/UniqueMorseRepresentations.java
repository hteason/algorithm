package htc.leetcode.other;

import java.util.HashMap;
import java.util.Map;

public class UniqueMorseRepresentations {
	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(
				new String[] {"gin", "zen", "gig", "msg"}));;
	}
	public static int uniqueMorseRepresentations(String[] words) {
        String[] alph = {".-","-...","-.-.","-..",".","..-.","--.", "....",
        		"..",".---","-.-",".-..","--","-.","---",".--.","--.-",
        		".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, String> map = new HashMap<>();
        for (String s : words) {
        	StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				sb.append(alph[c-97]);
			}
			map.put(sb.toString(), sb.toString());
		}
    	return map.size();
    }
}
