

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	final static long INF = 987654321;
	static long[][] a = new long[104][104];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		// INF
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = INF;
			}
		}

		// INPUT
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	
			a[f][t] = Math.min(a[f][t], w);
		}
		
		// [k i j], [i k k j]
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)continue; // k == i
				
				for (int j = 1; j <= n; j++) {
					if (i == j || k == j) continue; // i == j || k == j
					
					a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]); // i j, i k k j
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (a[i][j] == INF)System.out.printf("%d ", 0);
				else System.out.printf("%d ", a[i][j]);
			}
			System.out.println();
		}
	}

}
