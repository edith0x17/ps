import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static ArrayList<int[]> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (0 < a[i][j] && a[i][j] < 6) cctvList.add(new int[]{i, j, a[i][j]});//x, y, type
            }
        }
        go(0, a);
        System.out.println(answer);
    }

    static void check(int[][] tmp) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) cnt++;
            }
        }
        answer = Math.min(answer, cnt);
    }

    static int[][] copy(int[][] map) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(map[i], m);
        }
        return tmp;
    }

    static void watch(int x, int y, int d, int[][] tmp) {
        while (true) {
            x += dx[d];
            y += dy[d];
            if (x < 0 || x >= n || y < 0 || y >= m) break;
            if (tmp[x][y] == 6) break;
            if (tmp[x][y] == 0) tmp[x][y] = 999;
        }
    }

    static void go(int depth, int[][] map) {
        if (depth == cctvList.size()) {
            check(map);
            return;
        }
        int[] cur = cctvList.get(depth);
        int x = cur[0], y = cur[1], type = cur[2];
        if (type == 1) {
            for (int i = 0; i < 4; i++) {
                int[][] tmp = copy(map);
                watch(x, y, i, tmp);
                go(depth + 1, tmp);
            }
        } else if (type == 2) {
            for (int i = 0; i < 4; i++) {
                int[][] tmp = copy(map);
                watch(x, y, i, tmp);
                watch(x, y, (i + 2) % 4, tmp);
                go(depth + 1, tmp);
            }
        } else if (type == 3) {
            for (int i = 0; i < 4; i++) {
                int[][] tmp = copy(map);
                watch(x, y, i, tmp);
                watch(x, y, (i + 1) % 4, tmp);
                go(depth + 1, tmp);
            }
        } else if (type == 4) {
            for (int i = 0; i < 4; i++) {
                int[][] tmp = copy(map);
                watch(x, y, i, tmp);
                watch(x, y, (i + 1) % 4, tmp);
                watch(x, y, (i + 2) % 4, tmp);
                go(depth + 1, tmp);
            }
        } else if (type == 5) {
            int[][] tmp = copy(map);
            for (int i = 0; i < 4; i++) {
                watch(x, y, i, tmp);
            }
            go(depth + 1, tmp);
        }
    }
}