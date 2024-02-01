import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] G; // 규영
	static int[] I; // 인영
	static int[] a;
	static boolean[] visitedTemp;
	static boolean[] visited;
	static int win, draw, lose;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			win = 0;
			draw = 0;
			lose = 0;

			G = new int[10]; // 규영
			I = new int[10]; // 인영

			a = new int[10]; // 인영 후보

			visitedTemp = new boolean[22];
			visited = new boolean[22];

			for (int i = 1; i <= 9; i++) { // 규영
				int temp = sc.nextInt();
				G[i] = temp;
				visitedTemp[temp] = true;
			}

			int idx = 1;
			for (int i = 1; i <= 9; i++) { // 인영
				for (int j = 1; j <= 18; j++) {
					if (G[i] != j && !visitedTemp[j]) {
						visitedTemp[j] = true;
						I[idx++] = j;
						break;
					}
				}
			}

//			System.out.println(Arrays.toString(G));
//			System.out.println(Arrays.toString(I));
			
			dfs(1); // idx가 1부터
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	static void dfs(int cnt) {
		if (cnt == 9 + 1) {
			check();
			
//			System.out.println(Arrays.toString(G));
//			System.out.println(Arrays.toString(a));
			
//			System.out.println("win : " + win);
//			System.out.println("draw : " + draw);
//			System.out.println("lose : " + lose);
			
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (visited[i]) {
				continue;
			}

			a[cnt] = I[i];
			visited[i] = true;

			dfs(cnt + 1);

			visited[i] = false;

		}
	}

	static void check() {
		int x = 0, y = 0;
		for (int i = 1; i <= 9; i++) {
			if (G[i] > a[i]) {
				x += G[i] + a[i];
			}else if(G[i] < a[i]) {
				y += G[i] + a[i];
			}
		}
		
		if(x > y)win++;
		else if(x < y)lose++;

	}
}