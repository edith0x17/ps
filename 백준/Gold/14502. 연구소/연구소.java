import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] aOri, tmp;
    static ArrayList<int[]> empty = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        aOri = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                aOri[i][j] = Integer.parseInt(st.nextToken());
                if (aOri[i][j] == 0) empty.add(new int[]{i, j});
                if (aOri[i][j] == 2) virus.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < empty.size(); i++) {
            for (int j = i + 1; j < empty.size(); j++) {
                for (int k = j + 1; k < empty.size(); k++) {
                    init();
                    go(i, j, k);
                }
            }
        }
        System.out.println(answer);
    }

    static void init() {
        tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(aOri[i], m);
        }
    }

    static void go(int i, int j, int k) {
        int[] p1 = empty.get(i);
        int[] p2 = empty.get(j);
        int[] p3 = empty.get(k);
        tmp[p1[0]][p1[1]] = 1;
        tmp[p2[0]][p2[1]] = 1;
        tmp[p3[0]][p3[1]] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for (int[] v : virus) {
            q.offer(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (tmp[nx][ny] == 1) continue;
                tmp[nx][ny] = 2;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (tmp[r][c] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }
}