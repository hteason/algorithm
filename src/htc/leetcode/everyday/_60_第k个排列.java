package htc.leetcode.everyday;

/**
 * WA
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class _60_第k个排列 {
    public static void main(String[] args) {
        _60_第k个排列 test = new _60_第k个排列();
//        System.out.println(test.getPermutation(3, 3));
        test = new _60_第k个排列();
        System.out.println(test.getPermutation(9, 300000));
    }

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        perm(0, n - 1, k, arr);
        return s.toString();
    }

    StringBuilder s = new StringBuilder();
    int count = 0;

    private void perm(int start, int n, int k, int[] arr) {
        if (start == n) {
            if (k == ++count) {
                for (int num : arr) {
                    s.append(num);
                }
            }
        } else {
            for (int i = start; i <= n; i++) {
                if (count > k){
                    continue;
                }
                swap(arr, start, i);
                perm(start + 1, n, k, arr);
                swap(arr, start, i);
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
