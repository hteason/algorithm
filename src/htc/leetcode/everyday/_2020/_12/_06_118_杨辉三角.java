package htc.leetcode.everyday._2020._12;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @date 2020/12/6
 */
public class _06_118_Ñî»ÔÈý½Ç {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmpList = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j != 0 && j != i) {
                    tmpList.add(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                } else {
                    tmpList.add(j, 1);
                }
            }
            list.add(i, tmpList);
        }
        return list;
    }
}
