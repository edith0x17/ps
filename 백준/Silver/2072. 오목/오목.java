import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {0, 1, 1, -1};
    static final int[] dy = {1, 0, 1, 1};
    static int n, answer;
    static boolean flag;
    static int[][] a = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int k = 1; k <= n; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (k % 2 == 1) a[x][y] = 1; //홀수 -> 흑
            else a[x][y] = 2; //짝수 -> 백

            if (k >= 5) {
                if (check()) {
                    answer = k;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) System.out.println(answer);
        else System.out.println(-1);
    }

    static boolean inBounds(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }

    static boolean check() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (a[i][j] == 0) continue;
                int color = a[i][j];
                for (int d = 0; d < 4; d++) {
                    int px = i - dx[d];
                    int py = j - dy[d];

                    if (inBounds(px, py) && a[px][py] == color) continue;

                    int cnt = 1;
                    int nx = i, ny = j;
                    while (true) {
                        nx += dx[d];
                        ny += dy[d];
                        if (!inBounds(nx, ny) || a[nx][ny] != color) break; //범위 || 장애물

                        cnt++;
                        if (cnt > 5) break;
                    }

                    if (cnt == 5) {
                        // 시작 -> 0에서
                        int ex = i + dx[d] * 5;
                        int ey = j + dy[d] * 5;

                        if (inBounds(ex, ey) && a[ex][ey] == color) continue;

                        return true;
                    }
                }
            }
        }

        return false;
    }
}