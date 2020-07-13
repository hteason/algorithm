package htc.leetcode.other;

import java.util.HashSet;
import java.util.Set;

public class _1051HeightChecker {

	//TODO δ���
	public static void main(String[] args) {
		System.out.println(heightChecker(new int[] {1,1,4,2,1,3}));
		System.out.println(heightChecker(new int[] {2,1,2,1,1,2,2,1}));
	}
    public static int heightChecker(int[] heights) {
        int ret = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
			for (int j = i+1; j < heights.length; j++) {
				if(heights[i]>heights[j]&&heights[j]<min) {
					//��¼��Сֵ�±�
					min = heights[j];
					minIndex = j;
				}
			}
			if(minIndex!=-1) {
				//��¼����ֵ
				set.add(i);
				set.add(minIndex);
				//����
				int tmp = heights[i];
				heights[i] = heights[minIndex];
				heights[minIndex] = tmp;
			}
		}
//        System.out.println(set);
    	ret = set.size();
    	return ret;
    }
}
