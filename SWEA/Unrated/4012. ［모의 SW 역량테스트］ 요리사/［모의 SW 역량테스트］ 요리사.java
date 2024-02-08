// package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int n, ans = 987654321;
	static int[][] a;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			ans = 987654321;

			n = Integer.parseInt(br.readLine());
			
			a = new int[n][n];
			visited = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			combi(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void combi(int idx, int start) {
		if (idx == n / 2) { 

			// 시뮬레이션 -> 방문O vs 방문X
			int sumA = 0, sumB = 0;
			// n [C] n/2
			for (int i = 0; i < n; i++) {
				
				for (int j = i + 1; j < n; j++) {
					
					if(visited[i] && visited[j]) {
						sumA += a[i][j] + a[j][i];
					}else if(!visited[i] && !visited[j]){
						sumB += a[i][j] + a[j][i];
					}
				}
			}
			
			ans = Math.min(ans, Math.abs(sumA - sumB));
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true; // 방문O
			
			combi(idx + 1, i + 1);
			
			visited[i] = false; // 방문X
		}
	}

}