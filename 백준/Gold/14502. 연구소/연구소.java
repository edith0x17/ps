import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map, ori;
    static ArrayList<int[]> virus = new ArrayList<>(), temp = new ArrayList<>();
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ori = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = ori[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) temp.add(new int[]{i, j}); // 빈 칸
                else if (map[i][j] == 2) virus.add(new int[]{i, j}); // 바이러스
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                for (int k = j + 1; k < temp.size(); k++) {
                    init();
                    visited = new boolean[n][m];

                    map[temp.get(i)[0]][temp.get(i)[1]] = 1;
                    map[temp.get(j)[0]][temp.get(j)[1]] = 1;
                    map[temp.get(k)[0]][temp.get(k)[1]] = 1;

                    answer = Math.max(answer, go());
                }
            }
        }
        System.out.println(answer);
    }
    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = ori[i][j];
            }
        }
    }
    static int go() {
        for (int[] arr : virus) {
            dfs(arr[0], arr[1]);
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) ret++;
            }
        }
        return ret;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
            if (map[nx][ny] != 0) continue;// 1 벽 2 바이러스
            dfs(nx, ny);
        }
    }
}