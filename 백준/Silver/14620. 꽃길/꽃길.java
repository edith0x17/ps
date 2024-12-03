import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int mi = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] candidate = new int[3];
        combi(0, 0, candidate);
        System.out.println(mi);
    }

    static void combi(int depth, int start, int[] candidate) {
        if (depth == 3) {
            visited = new boolean[n][n];
            mi = Math.min(mi, go(candidate));
            return;
        }
        for (int i = start; i < n * n; i++) { // 전체 범위에서 조합
            candidate[depth] = i;
            combi(depth + 1, i + 1, candidate);
        }
    }

    static int go(int[] candidate) {
        int ret = 0;
        boolean[][] tempVisited = new boolean[n][n];

        for (int j = 0; j < 3; j++) {
            int x = candidate[j] / n;
            int y = candidate[j] % n;

            // 가능
            if (tempVisited[x][y]) return Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || tempVisited[nx][ny])return Integer.MAX_VALUE;// 범위 || 방문 X -> return
            }

            // 방문
            tempVisited[x][y] = true;
            ret += map[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                tempVisited[nx][ny] = true;
                ret += map[nx][ny];
            }
        }
        return ret;
    }
}