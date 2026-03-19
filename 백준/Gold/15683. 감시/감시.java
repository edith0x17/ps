import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) cctvList.add(new int[]{i, j});
            }
        }
        dfs(0, map);
        System.out.println(answer);
    }

    static void check(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        answer = Math.min(answer, cnt);
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctvList.size()) {
            check(map);
            return;
        }
        int[] cur = cctvList.get(depth);
        int x = cur[0];
        int y = cur[1];
        int type = map[x][y];
        if (type == 1) {
            for (int d = 0; d < 4; d++) {
                int[][] copy = copy(map);
                watch(copy, x, y, d);
                dfs(depth + 1, copy);
            }
        } else if (type == 2) {
            for (int d = 0; d < 2; d++) {
                int[][] copy = copy(map);
                watch(copy, x, y, d);
                watch(copy, x, y, d + 2);
                dfs(depth + 1, copy);
            }
        } else if (type == 3) {
            for (int d = 0; d < 4; d++) {
                int[][] copy = copy(map);
                watch(copy, x, y, d);
                watch(copy, x, y, (d + 1) % 4);
                dfs(depth + 1, copy);
            }
        } else if (type == 4) {
            for (int d = 0; d < 4; d++) {
                int[][] copy = copy(map);
                for (int k = 0; k < 3; k++) {
                    watch(copy, x, y, (d + k) % 4);
                }
                dfs(depth + 1, copy);
            }
        } else if (type == 5) {
            int[][] copy = copy(map);
            for (int d = 0; d < 4; d++) {
                watch(copy, x, y, d);
            }
            dfs(depth + 1, copy);
        }
    }

    static void watch(int[][] map, int x, int y, int d) {
        while (true) {
            x += dx[d];
            y += dy[d];

            if (x < 0 || x >= n || y < 0 || y >= m) break;//범위
            if (map[x][y] == 6) break;//장애물
            if (map[x][y] == 0) map[x][y] = -1;
        }
    }

    static int[][] copy(int[][] map) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(map[i], m);
        }
        return tmp;
    }
}