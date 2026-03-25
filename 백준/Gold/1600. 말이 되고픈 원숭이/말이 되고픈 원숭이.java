import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseDy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int k, w, h;
    static int[][] a;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        a = new int[h][w];
        visited = new int[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0][0] = 1;
        q.offer(new int[]{0, 0, 0});//x, y, cnt
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];
            for (int i = 0; i < 4; i++) {//원숭이 항상
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (visited[nx][ny][cnt] != 0) continue;
                if (a[nx][ny] == 1) continue;
                visited[nx][ny][cnt] = visited[x][y][cnt] + 1;
                q.offer(new int[]{nx, ny, cnt});
            }
            if (cnt < k) {//말
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseDx[i];
                    int ny = y + horseDy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (visited[nx][ny][cnt + 1] != 0) continue;
                    if (a[nx][ny] == 1) continue;
                    visited[nx][ny][cnt + 1] = visited[x][y][cnt] + 1;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visited[h - 1][w - 1][i] != 0) {
                ans = Math.min(ans, visited[h - 1][w - 1][i]);
            }
        }
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans - 1);
    }
}