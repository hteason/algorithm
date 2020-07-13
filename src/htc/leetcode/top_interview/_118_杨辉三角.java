package htc.leetcode.top_interview;

import java.util.ArrayList;
import java.util.List;

public class _118_Ñî»ÔÈý½Ç {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		for (int i = 0; i < numRows; i++) {
			List<Integer> tmpList = new ArrayList<>(i);
			for (int j = 0; j <= i; j++) {
				if(j!=0&&j!=i) {
					tmpList.add(j,list.get(i-1).get(j-1)+list.get(i-1).get(j));
				}else {
					tmpList.add(j,1);
				}
			}
			list.add(i,tmpList);
		}
		return list;
	}
}
