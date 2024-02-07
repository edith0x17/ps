// package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int retx, rety, room, distance;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] a;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			room = 987654321;
			distance = 0;
			
			n = Integer.parseInt(br.readLine());
			
			a = new int[n][n];
			
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new int[n][n];

					int l = dfs(i, j);
					
					if(distance < l) { // 같은거리 X
						distance = l;
						room = a[i][j];
					}else if(distance == l) { // 같은 거리 O 
						
						if(a[i][j] < room) { // 방번호 min
							room = a[i][j];
						}
					}
					
				}
			}

			System.out.println("#" + tc + " " + room + " " + distance);
		}
	}

	static int dfs(int x, int y) {
		visited[x][y] = 1;
		int ret = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] == 1 || (a[nx][ny]) != (a[x][y] + 1))
				continue;

			ret += dfs(nx, ny);
		}
		return ret;
	}
}