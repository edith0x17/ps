import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (check(depth)) answer++;

        if (depth == n * m) return;

        for (int i = idx; i < n * m; i++) {
            int r = i / m, c = i % m;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            dfs(depth + 1, i + 1); //다음 인덱스부터 재귀 -> 순열에서 조합으로
            visited[r][c] = false;
        }
    }

    static boolean check(int depth) {
        if (depth < 4) return true;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}