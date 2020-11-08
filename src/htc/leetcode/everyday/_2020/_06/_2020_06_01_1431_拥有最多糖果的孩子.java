package htc.leetcode.everyday._2020._06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2020_06_01_1431_拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        List<Boolean> isMost = new ArrayList<>(candies.length);
        int max = Arrays.stream(candies).max().getAsInt();
        Arrays.stream(candies).forEach(candy->{isMost.add(candy+extraCandies>= max);});
        return isMost;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> isMost = new ArrayList<>(candies.length);

        int max = candies[0];
        for(int i = 1; i < candies.length;i++){
            max = Math.max(candies[i],max);
        }

        for(int candy : candies){
            isMost.add(candy+extraCandies >= max);
        }
        return isMost;
    }	
}
