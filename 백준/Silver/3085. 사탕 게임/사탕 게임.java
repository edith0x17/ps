import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] a;
    static int mx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        // 모든 위치에서 스왑 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                go(i, j);
            }
        }

        System.out.println(mx);
    }

    static void go(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            swap(x, y, nx, ny);
            calculateMax(); // 스왑 후 최대 연속 길이 계산
            swap(x, y, nx, ny); // 원래대로 복원
        }
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;
    }

    static void calculateMax() {
        // 행 탐색
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                mx = Math.max(mx, cnt);
            }
        }

        // 열 탐색
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (a[i][j] == a[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                mx = Math.max(mx, cnt);
            }
        }
    }
}