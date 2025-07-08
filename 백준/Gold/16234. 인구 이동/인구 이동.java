import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, l, r;
    static int[][] a;
    static boolean[][] visited;
    static boolean flag = false;
    static int sum;
    static ArrayList<Data> adj;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            visited = new boolean[n][n];
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        sum = 0;
                        adj = new ArrayList<>();
                        dfs(i, j);
                        if (adj.size() > 1) { // 사이즈 
                            for (int k = 0; k < adj.size(); k++) {
                                a[adj.get(k).x][adj.get(k).y] = sum / adj.size();
                            }
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) break;
            answer++;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        sum += a[x][y];
        adj.add(new Data(x, y));
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 범위
            if (visited[nx][ny]) continue; // 방문
            if (l <= Math.abs(a[x][y] - a[nx][ny]) && Math.abs(a[x][y] - a[nx][ny]) <= r) { // 장애물
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