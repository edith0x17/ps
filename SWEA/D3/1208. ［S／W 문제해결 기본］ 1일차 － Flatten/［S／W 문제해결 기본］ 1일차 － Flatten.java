

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int dump;
	static int[] arr = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			dump = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(Arrays.toString(arr));
			int ret = go();
			System.out.println("#" + t + " " + ret);
		}
	}

	static int go() {
		int ret = 0;
		int mx_idx = -1, mi_idx = -1;
		int mx = 0, mi = 1004;

		for (int j = 0; j < dump; j++) {
			mx_idx = -1; mi_idx = -1;
			mx = 0; mi = 1004;
			for (int i = 0; i < 100; i++) {
				if (mx < arr[i]) {
					mx = arr[i];
					mx_idx = i;
				}

				if (mi > arr[i]) {
					mi = arr[i];
					mi_idx = i;
				}
			}
			
//			System.out.println(mx);
//			System.out.println(mi);
			
			arr[mx_idx]--;
			arr[mi_idx]++;
//			System.out.println(Arrays.toString(arr));

		}

		mx = 0;
		mi = 1004;

		for (int i = 0; i < 100; i++) {
			if (mx < arr[i]) {
				mx = arr[i];
			}

			if (mi > arr[i]) {
				mi = arr[i];
			}

		}

		ret = mx - mi;
		return ret;
	}

}
