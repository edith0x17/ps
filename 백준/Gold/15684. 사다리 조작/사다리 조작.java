import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static boolean[][] a;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        a = new boolean[h + 1][n + 1];//
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x][y] = true;
        }

        for (int i = 0; i <= 3; i++) {
            go(0, i, 1);
            if (answer != Integer.MAX_VALUE) break;
        }
        if (answer != Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println(-1);
    }

    static boolean check() {//사다리
        for (int i = 1; i <= n; i++) {
            int col = i;
            for (int row = 1; row <= h; row++) {
                if (a[row][col]) col++;
                else if (col > 1 && a[row][col - 1]) col--;
            }
            if (col != i) return false;
        }
        return true;
    }

    static void go(int cnt, int maxCnt, int start) {
        if (cnt == maxCnt) {
            if (check()) answer = Math.min(answer, cnt);
            return;
        }

        if (cnt >= answer) return;//가지치기

        for (int i = start; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] || a[i][j - 1] || a[i][j + 1]) continue;//지금 || 지금의 왼쪽 || 지금의 오른쪽
                a[i][j] = true;
                go(cnt + 1, maxCnt, i);
                a[i][j] = false;
            }
        }
    }
}