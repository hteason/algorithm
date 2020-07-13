package htc.leetcode.other;

import java.util.HashSet;
import java.util.Set;
//929
public class NumUniqueEmails {
	public static void main(String[] args) {
		int size = numUniqueEmails2(new String[] {
				"test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com"
});
		System.out.println(size);
	}

	public static int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			int addIndex = email.indexOf("+");
			set.add(addIndex == -1?email.substring(0, email.indexOf('@'))
					.replace(".", "")
					+ email.substring(email.indexOf('@'))
							:
								email.substring(0, email.indexOf('@'))
						.substring(0, addIndex)
						.replace(".", "")
						+ email.substring(email.indexOf('@')));
			}
		return set.size();
	}
	
	//split
	public static int numUniqueEmails2(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			String[] sub = email.split("@");
			String[] sub2 = sub[0].split("\\+");
			sub2[0] = sub2[0].replace(".", "");
			set.add(sub2[0]+"@"+sub[1]);	
			System.out.println(sub2[0]+"@"+sub[1]);
			}
		return set.size();
	}
}
