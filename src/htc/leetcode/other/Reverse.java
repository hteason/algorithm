package htc.leetcode.other;
//7. 整数反转
public class Reverse {
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 31)-1+" "+new Reverse().reverse(1534236469));;
	}
    public int reverse(int x) {
    	long ret = 0;
        while(x != 0) {
			ret = ret*10 + x%10;
			if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
				return 0;
			}
			x/=10;
		}
    	return (int)ret;
    }
}
