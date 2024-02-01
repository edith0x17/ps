import java.util.Scanner;

public class Solution{
	
	static int n, l; // 재료수, 칼로리
	static int[] a, b;
	static boolean[] visited;
	static int mx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			mx = 0;
			
			n = sc.nextInt();
			l = sc.nextInt();
			
			a = new int[n];
			b = new int[n];
			visited = new boolean[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt(); // 점수
				b[i] = sc.nextInt(); // 칼로리
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + mx);
		}
		
	}
	
	static void dfs(int cnt, int cal, int score) { // 칼로리 -> b, 점수 -> a
		
		if(cnt == n) {
//			System.out.println(score);
			if(cal <= l) { 
				mx = Math.max(mx, score);
			}
			
			return;
		}
		
		visited[cnt] = true;
		dfs(cnt + 1, cal + b[cnt], score + a[cnt]);
		
		visited[cnt] = false;
		dfs(cnt + 1, cal, score);
			
	}
}