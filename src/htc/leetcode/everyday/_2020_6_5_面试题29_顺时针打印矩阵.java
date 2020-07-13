package htc.leetcode.everyday;

import java.util.Arrays;

public class _2020_6_5_������29_˳ʱ���ӡ���� {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(spiralOrder(new int[][] {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9}
//		})));
//		System.out.println(Arrays.toString(spiralOrder(new int[][] {
//		{1,2,3,4},
//		{5,6,7,8},
//		{9,10,11,12}
//	})));
		System.out.println(Arrays.toString(spiralOrder(new int[][] {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,15,16}
	})));
	}
    public static int[] spiralOrder(int[][] matrix) {
    	if (matrix.length==0) {
			return new int[] {};
		}
    	int[] ans = new int[matrix.length*matrix[0].length];
    	int step = matrix.length*matrix[0].length;
    	int end1 = matrix[0].length;
    	int end2 = matrix.length;
    	int start1 = 0;
    	int start2 = 2;
    	int s = 0;
    	int i = 0;
    	int j = 0;
    	while(s < step) {
    		//�������ұ���
    		while(j < end1) {
    			ans[s++] = matrix[i][j++];
    		}
    		end1--;
    		if (s>step) {
				break;
			}
    		j--;
    		//�������±���
    		while(++i < end2) {
    			ans[s++] = matrix[i][j];
    		}
    		end2--;
    		if (s>step) {
				break;
			}
    		//�����������
    		--i;
    		while(j-- > start1) {
    			ans[s] = matrix[i][j];
    			s++;
    		}
    		start1++;
    		if (s>step) {
				break;
			}
    		//�������ϱ���
    		j++;

    		while(i-- > start2) {
    			ans[s] = matrix[i][j];
    			s++;
    		}
    		start2++;
    	}
    	return ans;
    }
}
