import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, m, answer = Integer.MIN_VALUE;
    static int[][] map;

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
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) continue;
                int temp = bfs(i, j); //그 칸과 가장 거리가 가까운 아기 상어와의 거리
                answer = Math.max(answer, temp);
            }
        }
        System.out.println(answer - 1);
    }

    static int bfs(int x, int y) {
        Queue<Data> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        visited[x][y] = 1;
        q.offer(new Data(x, y));
        while (!q.isEmpty()) {
            Data here = q.poll();
            for (int d = 0; d < 8; d++) {
                int nx = here.x + dx[d];
                int ny = here.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; //범위
                if (visited[nx][ny] != 0) continue; //방문
                if (map[nx][ny] == 1) return visited[here.x][here.y] + 1;

                visited[nx][ny] = visited[here.x][here.y] + 1;
                q.offer(new Data(nx, ny));
            }
        }
        return 0;
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}