import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m, t;
    static int[][] a;
    static boolean hasGram = false;
    static int x, y;
    static Queue<Data> q;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 2) {
                    hasGram = true;
                    x = i;
                    y = j;
                }
            }
        }

        bfs(0, 0);
        int result = Integer.MAX_VALUE;
        if (visited[n - 1][m - 1] != 0) {
            result = visited[n - 1][m - 1] - 1;
        }
        if (hasGram && visited[x][y] != 0) {
            int distToGram = visited[x][y] - 1;
            int distFromGramToEnd = (n - 1 - x) + (m - 1 - y);
            result = Math.min(result, distToGram + distFromGramToEnd);
        }
        System.out.println(result <= t ? result : "Fail");
    }

    static void bfs(int x, int y) {
        q = new ArrayDeque<>();
        visited = new int[n][m];

        visited[x][y] = 1;
        q.offer(new Data(x, y));
        while (!q.isEmpty()) {
            Data data = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (a[nx][ny] == 1) continue;
                visited[nx][ny] = visited[data.x][data.y] + 1;
                q.offer(new Data(nx, ny));
            }
        }
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}