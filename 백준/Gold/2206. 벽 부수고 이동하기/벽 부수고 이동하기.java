import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        q.offer(new int[]{0, 0, 0});//x, y, wall
        visited[0][0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], wall = cur[2];

            if (x == n - 1 && y == m - 1) {
                System.out.println(visited[x][y][wall]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위
                if (a[nx][ny] == 0 && visited[nx][ny][wall] == 0) {//빈칸 이동
                    visited[nx][ny][wall] = visited[x][y][wall] + 1;
                    q.offer(new int[]{nx, ny, wall});
                }
                if (a[nx][ny] == 1 && wall == 0 && visited[nx][ny][1] == 0) {//벽 부수기
                    visited[nx][ny][1] = visited[x][y][0] + 1;
                    q.offer(new int[]{nx, ny, 1});
                }
            }
        }
        System.out.println(-1);
    }
}