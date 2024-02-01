import java.util.Scanner;

public class Main {

	static int n;
	static int[] s, b;
	static int mi = 1000000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		s = new int[n];
		b = new int[n];

		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		int S = (1 << n);

		for (int i = 1; i < S; i++) {

			int sumS = 1, sumB = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sumS *= s[j];
					sumB += b[j];
				}
			}

			mi = Math.min(mi, Math.abs(sumS - sumB));

		}
		System.out.println(mi);
	}
}