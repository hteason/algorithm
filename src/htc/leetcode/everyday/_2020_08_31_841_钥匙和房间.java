package htc.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 * https://leetcode-cn.com/problems/keys-and-rooms/
 */
public class _2020_08_31_841_钥匙和房间 {
    public static void main(String[] args) {
        _2020_08_31_841_钥匙和房间 test = new _2020_08_31_841_钥匙和房间();


        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list.add(list3);

        list.add(new ArrayList<>());

        System.out.println(test.canVisitAllRooms(list));

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> lists1 = new ArrayList<>();
        lists1.add(1);
        lists1.add(3);
        lists.add(lists1);
        List<Integer> lists2 = new ArrayList<>();
        lists2.add(3);
        lists2.add(0);
        lists2.add(1);
        lists.add(lists2);
        List<Integer> lists3 = new ArrayList<>();
        lists3.add(2);
        lists.add(lists3);
        List<Integer> lists4 = new ArrayList<>();
        lists4.add(0);
        lists.add(lists4);
        System.out.println(test.canVisitAllRooms(lists));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //记录房间是否访问过
        boolean[] visit = new boolean[rooms.size()];
        //从房间0开始
        dfs(rooms, visit, 0);
        for (boolean b : visit) {
            //如果最后有房间没遍历过,则直接false
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visit, int step) {
        //没访问过才能访问
        if (!visit[step]) {
            //获取当前房间能进入的下一房间列表
            List<Integer> keys = rooms.get(step);
            if (keys.size() == 0) {
                //若没有进入下一个房间的钥匙，默认设置为已访问
                visit[step] = true;
            }
            for (Integer num : keys) {
                //将当前房间标记为已访问
                visit[step] = true;
                //num：下一房间
                dfs(rooms, visit, num);
            }
        }
    }
}
