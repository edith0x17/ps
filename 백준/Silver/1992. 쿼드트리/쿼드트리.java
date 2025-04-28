import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        go(n, 0, 0);
        System.out.println(sb);
    }

    static boolean check(int size, int x, int y) {
        int prev = a[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (prev != a[i][j]) return false;
            }
        }
        return true;
    }

    static void go(int size, int x, int y) {
        if (check(size, x, y)) {
            if (a[x][y] == 1) sb.append(1);
            else sb.append(0);

            return;
        }
        sb.append('(');
        go(size / 2, x, y);
        go(size / 2, x, y + size / 2);
        go(size / 2, x + size / 2, y);
        go(size / 2, x + size / 2, y + size / 2);
        sb.append(')');
    }
}