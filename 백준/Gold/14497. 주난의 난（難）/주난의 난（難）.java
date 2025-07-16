import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m, turn;
    static int x1, y1, x2, y2;
    static int[][] a;
    static boolean[][] visited;
    static Queue<Data> q = new ArrayDeque<>();
    static Queue<Data> tempQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        a = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '0') a[i][j] = 0;
                else if (s.charAt(j) == '1') a[i][j] = 1;
                else if (s.charAt(j) == '*') a[i][j] = 0; // 주난
                else if (s.charAt(j) == '#') a[i][j] = 0; // 범인
            }
        }
        visited[x1][y1] = true;
        q.offer(new Data(x1, y1));
        while (true) {
            turn++;
            while (!q.isEmpty()) {
                Data now = q.poll();

                if (now.x == x2 && now.y == y2) {
                    System.out.println(turn);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위
                    if (visited[nx][ny]) continue; // 방문
                    if (a[nx][ny] == 1) {
                        a[nx][ny] = 0;
                        visited[nx][ny] = true;
                        tempQ.offer(new Data(nx, ny));
                    } else if (a[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Data(nx, ny));
                    }
                }
            }
            q = tempQ;
            tempQ = new ArrayDeque<>();
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