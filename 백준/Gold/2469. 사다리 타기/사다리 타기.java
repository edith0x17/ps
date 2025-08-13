import java.io.*;
import java.util.*;

public class Main {
    static int k, n, q = -1;
    //dash[r][c] == true 면 r행의 c ~ c+1 사이에 '-'가 존재
    static boolean[][] dash;
    static String target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        dash = new boolean[n][k - 1];
        target = br.readLine();
        for (int r = 0; r < n; r++) {
            String line = br.readLine().trim();
            for (int c = 0; c < k - 1; c++) {
                char ch = line.charAt(c);
                if (ch == '-') dash[r][c] = true;
                else if (ch == '?') q = r;
            }
        }

        char[] top = new char[k];
        for (int i = 0; i < k; i++){
            top[i] = (char) ('A' + i);
        }
        for (int r = 0; r < q; r++) {
            for (int c = 0; c < k - 1; c++) {
                if (dash[r][c]) swap(top, c, c + 1);
            }
        }

        char[] bot = target.toCharArray();
        for (int r = n - 1; r > q; r--) {
            for (int c = 0; c < k - 1; c++) {
                if (dash[r][c]) swap(bot, c, c + 1);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int c = 0; c < k - 1; c++) {
            if (top[c] == bot[c]) {
                ans.append('*');
            } else if (top[c] == bot[c + 1] && top[c + 1] == bot[c]) {
                ans.append('-');
                swap(top, c, c + 1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k - 1; i++) sb.append('x');
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println(ans.toString());
    }

    static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}