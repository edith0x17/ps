import java.io.*;
import java.util.*;

public class Main {
    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {1, 0, -1, 0};
    static int n;
    static int[][] a = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            ArrayList<Integer> adj = new ArrayList<>();
            adj.add(d);
            for (int i = 0; i < g; i++) {
                for (int j = adj.size() - 1; j >= 0; j--) {
                    adj.add((adj.get(j) + 1) % 4);
                }
            }
            a[y][x] = 1;
            for (int dir : adj) {
                y += dy[dir];
                x += dx[dir];
                a[y][x] = 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (a[i][j] == 1 && a[i][j + 1] == 1 && a[i + 1][j] == 1 && a[i + 1][j + 1] == 1) answer++;
            }
        }
        System.out.println(answer);
    }
}