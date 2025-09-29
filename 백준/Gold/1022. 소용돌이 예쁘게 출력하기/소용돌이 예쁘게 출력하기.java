import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {0, -1, 0, 1}; 
    static final int[] dy = {1, 0, -1, 0};
    static int r1, c1, r2, c2;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        int row = r2 - r1 + 1;
        int col = c2 - c1 + 1;
        a = new int[row][col];
        int x = 0, y = 0, num = 1;
        int dir = 0, step = 1;
        while (true) {
            for (int t = 0; t < 2; t++) {
                for (int i = 0; i < step; i++) {
                    if (r1 <= x && x <= r2 && c1 <= y && y <= c2) {
                        a[x - r1][y - c1] = num;
                    }
                    if (a[0][0] != 0 && a[0][col - 1] != 0 && a[row - 1][0] != 0 && a[row - 1][col - 1] != 0) {
                        printArray(a);
                        return;
                    }
                    x += dx[dir];
                    y += dy[dir];
                    num++;
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
    }

    static void printArray(int[][] arr) {
        int maxLen = 0;
        for (int[] row : arr) {
            for (int val : row) {
                maxLen = Math.max(maxLen, val);
            }
        }
        int len = String.valueOf(maxLen).length();
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(String.format("%" + len + "d ", val));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}