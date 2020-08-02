package htc.leetcode.greed;

/**
 * AC
 * https://leetcode-cn.com/problems/water-bottles/
 */
public class _1518_�������� {
    public static void main(String[] args) {
        _1518_�������� test = new _1518_��������();
        System.out.println(test.numWaterBottles(9,3));
        System.out.println(test.numWaterBottles(15,4));
        System.out.println(test.numWaterBottles(5,5));
        System.out.println(test.numWaterBottles(2,3));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while(numBottles >= numExchange){
            sum += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return sum;
    }
}
