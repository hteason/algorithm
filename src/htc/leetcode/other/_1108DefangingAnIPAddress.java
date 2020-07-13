package htc.leetcode.other;

public class _1108DefangingAnIPAddress {

	public static void main(String[] args) {
		System.out.println(new _1108DefangingAnIPAddress().defangIPaddr2("1.1.1.1"));
		System.out.println(new _1108DefangingAnIPAddress().defangIPaddr2("255.100.50.0"));
	}

	public String defangIPaddr(String address) {
		return address.replace(".", "[.]");
	}
	public String defangIPaddr2(String address) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0,len = address.length(); i < len; i++) {
			if(address.charAt(i)=='.') {
				sb.append("[.]");
			}else {
				sb.append(address.charAt(i));
			}
		}
		return sb.toString();
	}
}
