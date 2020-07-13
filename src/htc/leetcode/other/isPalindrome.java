package htc.leetcode.other;

public class isPalindrome {
	public static void main(String[] args) {
		new isPalindrome().palindrome(121);
	}
	public boolean palindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x>=0 && x < 10){
            return true;
        }
        String s = x+"";
        int len  =s.length();
        for(int i = 0 ;i< len/2 ;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)) {
            	return false;
            }
        }
        return true;
    }
}
