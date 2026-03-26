import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, x, y, d;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (true) {
            //1
            if (a[x][y] == 0) {
                a[x][y] = 999;
                cnt++;
            }

            //2
            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 4 - 1) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위
                if (a[nx][ny] != 0) continue;//장애물(벽 || 999)
                x = nx;
                y = ny;
                moved = true;
                break;
            }
            if (moved) continue;

            //3
            int nx = x - dx[d];
            int ny = y - dy[d];
            if (a[nx][ny] == 1) break;
            x = nx;
            y = ny;
        }
        System.out.println(cnt);
    }
}