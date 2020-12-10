package htc.leetcode.everyday._2020._12;

/**
 * AC
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * @date 2020/12/10
 */
public class _10_860_ÄûÃÊË®ÕÒÁã {
    public static void main(String[] args) {
        _10_860_ÄûÃÊË®ÕÒÁã test = new _10_860_ÄûÃÊË®ÕÒÁã();
        System.out.println(test.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(test.lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(test.lemonadeChange(new int[]{10, 10}));
        System.out.println(test.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(test.lemonadeChange(new int[]{5, 5, 10, 10, 5, 20, 5, 10, 5, 5}));
    }

    //´¿if-else
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0 || bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int five = 1;
        int ten = 0;
        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten * 10 + five * 5 < 15) {
                    return false;
                }

                if (ten >= 1) {
                    ten--;
                    if (five < 1) {
                        return false;
                    } else {
                        five--;
                    }
                } else {
                    if (five < 3) {
                        return false;
                    } else {
                        five -= 3;
                    }
                }
            }
        }
        return true;
    }

    //ÓÅ»¯1
    public boolean lemonadeChange2(int[] bills) {
        if (bills == null || bills.length == 0 || bills[0] == 10 || bills[0] == 20) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;

                case 10:
                    if (five <= 0) {
                        return false;
                    }
                    five--;
                    ten++;
                    break;

                case 20:
                    if (ten >= 1 && five >= 1) {
                        ten--;
                        five--;
                    } else if (ten == 0 && five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
            }
        }
        return true;
    }
}
