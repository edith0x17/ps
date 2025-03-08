import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer;
    static int[][] a, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // check
            ArrayList<Data> adj = check();
            if (adj.isEmpty()) break;

            // 시간
            answer++;

            // init
            init();

            // 외부공기/내부공기
            dfs(0, 0);

            // 녹이기
            for (Data data : adj) {
                int cnt = 0;
                int x = data.x;
                int y = data.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (visited[nx][ny] == -1) cnt++;
                }
                if (cnt >= 2)a[x][y] = 0;
            }
        }
        System.out.println(answer);
    }
    static ArrayList<Data> check() {
        ArrayList<Data> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) ret.add(new Data(i, j));
            }
        }
        return ret;
    }
    static void init() {
        visited = new int[n][m];
    }
    static void dfs(int x, int y) {
        visited[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny] != -1 && a[nx][ny] == 0) {
                dfs(nx, ny);
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