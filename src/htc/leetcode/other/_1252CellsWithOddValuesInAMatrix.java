package htc.leetcode.other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//TODO Î´Íê³É
public class _1252CellsWithOddValuesInAMatrix {

	public static void main(String[] args) {
		_1252CellsWithOddValuesInAMatrix t = new _1252CellsWithOddValuesInAMatrix();
//		t.oddCells(2, 3, new int[][] { { 0, 1 }, { 1, 1 } });
//		t.oddCells(2, 2, new int[][] { { 1, 1 }, { 0, 0 } });
		System.out.println(t.oddCells(2, 2, new int[][] { { 1, 0 }, { 0, 0 } }));;
		System.out.println(t.oddCells(48, 37, new int[][] { { 40, 5 } }));;
	}

	public int oddCells(int n, int m, int[][] indices) {
		Map<Integer, Integer> rowMap = new HashMap<>();
		Map<Integer, Integer> colMap = new HashMap<>();
		for (int i = 0; i < indices.length; i++) {
			int row = indices[i][0];
			int col = indices[i][1];
			rowMap.put(row, rowMap.getOrDefault(row, 0)+1);
			colMap.put(col, colMap.getOrDefault(col, 0)+1);
		}

//		System.out.println(rowMap);
//		System.out.println(colMap);
		int rowCnt = 0;
		for(Map.Entry<Integer,Integer> e:rowMap.entrySet()) {
			if(e.getValue()%2==1)
				rowCnt++;
		}
		int colCnt = 0;
		for(Map.Entry<Integer,Integer> e:colMap.entrySet()) {
			if(e.getValue()%2==1)
				colCnt++;
		}
		int ret = 0;
		if(rowCnt == 0 || colCnt == 0) {
			ret = rowCnt*m+colCnt*n;
		}else {
			ret = rowCnt*m-colCnt*n-(rowCnt+colCnt);
		}
		return ret;
	}
}
