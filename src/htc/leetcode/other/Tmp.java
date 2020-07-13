package htc.leetcode.other;

import java.util.Scanner;

public class Tmp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 3;
		n = sc.nextInt();

		int[] x = {3,15,18};
		int[] y = {3,14,21};

		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(find(x, y, 0, 0, n));

	}

	public static int find(int[] x, int[] y, int a, int b, int n) {
		int k, q;
		if (n == 1)
			return x[a] <= y[b] ? x[a] : y[b];

		k = (n - 1) / 2;
		if (n % 2 != 0) {
			q = k;
		} else {
			q = k + 1;
		}
		int j = x[a + k];
		int p = y[b + k];
		if (j == p)
			return x[a + k];
		else if (j < p)
			return find(x, y, a + q, b, k + 1);
		else
			return find(x, y, a, b + q, k + 1);

	}

}
