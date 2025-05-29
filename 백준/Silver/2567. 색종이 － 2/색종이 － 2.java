import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] a = new int[101][101];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    a[i][j] = 1;
                }
            }
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (a[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101 || a[nx][ny] == 0) {
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}