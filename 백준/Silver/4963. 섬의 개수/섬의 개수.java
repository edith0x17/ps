import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            cnt = 0;
//            m, n
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        // 실행
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue; // 범위 

            if (map[nx][ny] == 1 && !visited[nx][ny]) { // 섬 && 방문
                dfs(nx, ny);
            }
        }
    }
}
