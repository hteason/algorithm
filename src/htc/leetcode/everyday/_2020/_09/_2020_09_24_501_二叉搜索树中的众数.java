package htc.leetcode.everyday._2020._09;

import htc.leetcode.datatype.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AC
 * 太暴力
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class _2020_09_24_501_二叉搜索树中的众数 {

    int max = Integer.MIN_VALUE;
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        if(root.left==null && root.right == null){
            return new int[]{root.val};
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        dfs(root,map);
        List<Integer> list = new ArrayList<>(map.size());
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue().equals(max)){
                list.add(e.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0, size = list.size(); i < size ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void dfs(TreeNode root, Map<Integer,Integer> map) {
        if(root == null) {
            return;
        }
        int val = map.getOrDefault(root.val,0)+1;
        max = Math.max(max, val);
        map.put(root.val,val);
        dfs(root.left,map);
        dfs(root.right,map);
    }
}
