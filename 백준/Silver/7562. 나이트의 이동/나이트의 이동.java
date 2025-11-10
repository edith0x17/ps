import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int t, n, sx, sy, ex, ey;
    static int[][] visited;
    static Queue<Data> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            visited = new int[n][n];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            q = new ArrayDeque<>();
            visited[sx][sy] = 1;
            q.offer(new Data(sx, sy));
            while (!q.isEmpty()) {
                Data data = q.poll();
                if (data.x == ex && data.y == ey) {
                    System.out.println(visited[ex][ey] - 1);
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = data.x + dx[i];
                    int ny = data.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;//범위
                    if (visited[nx][ny] != 0) continue;//방문
                    visited[nx][ny] = visited[data.x][data.y] + 1;
                    q.offer(new Data(nx, ny));
                }
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