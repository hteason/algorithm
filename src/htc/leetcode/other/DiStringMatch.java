package htc.leetcode.other;

import java.util.Arrays;

public class DiStringMatch {
public static void main(String[] args) {
	System.out.println(Arrays.toString(diStringMatch("DDI")));;
}
    public static int[] diStringMatch(String S) {
    	int len = S.length();
    	int max = len;
    	int min = 0;
    	int[] ret = new int[len+1];
    	char[] ch = S.toCharArray();
        for(int i = 0 ;i < len;i++) {
        	if(ch[i] == 'D') {
        		ret[i] = max--;
        	}else {
        		ret[i] = min++;
        	}
        }
        ret[len] = max;
    	return ret;
    }
}
