import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, f;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        f = Integer.parseInt(br.readLine());
        int sx = n / 2, sy = n / 2, num = 1, dir = 0, step = 1;
        map[sx][sy] = num++;
        while (num <= n * n) {
            for (int t = 0; t < 2 && num <= n * n; t++) {
                for (int s = 0; s < step && num <= n * n; s++) {
                    sx += dx[dir];
                    sy += dy[dir];
                    map[sx][sy] = num++;
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int fx = 0, fy = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == f) {
                    fx = i + 1;
                    fy = j + 1;
                }
                line.append(map[i][j]).append(' ');
            }
            line.append('\n');
            bw.write(line.toString());
        }
        bw.write(fx + " " + fy + "\n");
        bw.flush();
    }
}