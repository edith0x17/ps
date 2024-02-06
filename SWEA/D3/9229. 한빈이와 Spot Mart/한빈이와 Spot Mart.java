
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n, m, mx = -987654321;
	static int[] arr;
	static int[] ret;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			mx = -987654321;
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n + 4];
			ret = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			System.out.print("#" + t + " ");

			dfs(0, 0);
			
			if (mx != -987654321) {
				System.out.println(mx);
			} else {
				System.out.println(-1);
			}

		}
	}

	static void dfs(int depth, int start) {

		// 종료
		if (depth == 2) {

			// 시뮬레이션
			int temp = ret[0] + ret[1];
			if (temp <= m) {
				mx = Math.max(mx, temp);
			}
			return;
		}

		for (int i = start; i < n; i++) {

			ret[depth] = arr[i];
			dfs(depth + 1, i + 1); // depth == index
		}

	}
}