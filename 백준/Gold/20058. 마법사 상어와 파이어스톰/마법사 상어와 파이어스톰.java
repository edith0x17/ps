import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, q;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        map = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < q; k++) {
            int l = Integer.parseInt(st.nextToken());
            rotate(l);
            check();
        }
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
        int answer2 = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    answer2 = Math.max(answer2, dfs(i, j));
                }
            }
        }
        System.out.println(answer2);
    }

    static void rotate(int l) {
        int step = 1 << l;
        int[][] newMap = new int[map.length][map.length];
        for (int r = 0; r < map.length; r += step) {
            for (int c = 0; c < map.length; c += step) {
                for (int i = 0; i < step; i++) {
                    for (int j = 0; j < step; j++) {
                        newMap[r + j][c + step - 1 - i] = map[r + i][c + j];
                    }
                }
            }
        }
        map = newMap;
    }

    static void check() {
        List<int[]> toDecrease = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) continue;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
                    if (map[nx][ny] > 0) cnt++;
                }
                if (cnt < 3) toDecrease.add(new int[]{i, j});
            }
        }
        for (int[] pos : toDecrease) {
            map[pos[0]][pos[1]]--;
        }
    }

    static int dfs(int x, int y) {
        int ret = 1;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue; //범위
            if (visited[nx][ny]) continue; //방문
            if (map[nx][ny] == 0) continue; //장애물
            ret += dfs(nx, ny);
        }
        return ret;
    }
}