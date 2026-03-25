import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static boolean[][] a;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        a = new boolean[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a[r][c] = true;
        }
        for (int i = 0; i <= 3; i++) {
            go(0, i, 1);
            if (ans != Integer.MAX_VALUE) break;
        }
        if (ans != Integer.MAX_VALUE) System.out.println(ans);
        else System.out.println(-1);
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int col = i;
            for (int row = 1; row <= h; row++) {
                if (a[row][col]) col++;
                else if (a[row][col - 1]) col--;
            }
            if (col != i) return false;
        }
        return true;
    }

    static void go(int cnt, int mxCnt, int start) {
        if (cnt == mxCnt) {
            if (check()) ans = Math.min(ans, cnt);
            return;
        }
        if (cnt >= ans) return;
        for (int i = start; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] || a[i][j - 1] || a[i][j + 1]) continue;
                a[i][j] = true;
                go(cnt + 1, mxCnt, i);
                a[i][j] = false;
            }
        }
    }
}