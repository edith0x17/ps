import java.io.*;
import java.util.*;

public class Main {
    static class Data {
        int x, y;
        int breaWallCnt;
        int cnt;
        public Data(int x, int y, int breaWallCnt, int cnt) {
            this.x = x;
            this.y = y;
            this.breaWallCnt = breaWallCnt;
            this.cnt = cnt;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited; // [k+1][n][m] 구조로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[k + 1][n][m]; // [k+1][n][m] 크기 조정

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        sb.append(bfs());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Data> q = new ArrayDeque<>();
        q.offer(new Data(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Data data = q.poll();

            if (data.x == n - 1 && data.y == m - 1) return data.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == 1) { // 벽이 있는 경우
                    if (data.breaWallCnt < k && !visited[data.breaWallCnt + 1][nx][ny]) {
                        q.offer(new Data(nx, ny, data.breaWallCnt + 1, data.cnt + 1));
                        visited[data.breaWallCnt + 1][nx][ny] = true;
                    }
                } else { // 벽이 없는 경우
                    if (!visited[data.breaWallCnt][nx][ny]) {
                        q.offer(new Data(nx, ny, data.breaWallCnt, data.cnt + 1));
                        visited[data.breaWallCnt][nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}