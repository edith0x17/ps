import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, cnt = 2, answer = Integer.MAX_VALUE;
    static int[][] a;
    static int[][] visited;
    static Queue<Data> boarderQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && check(i, j)) boarderQueue.add(new Data(i, j));
                
                if (a[i][j] == 1 && visited[i][j] == 0) { // 장애물 || 방문
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        Queue<Data> q = new ArrayDeque<>();
        int[][] dist = new int[n][n]; // 거리 정보
        // boarderQueue → 초기 큐 세팅
        for (Data d : boarderQueue) {
            q.offer(d);
            dist[d.x][d.y] = 0;
        }
        while (!q.isEmpty()) {
            Data cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 같은 섬이면 그냥 continue
                if (visited[nx][ny] == visited[cur.x][cur.y]) continue;

                // 다른 섬을 만남 → 최소 다리 길이 후보
                if (visited[nx][ny] != 0 && visited[nx][ny] != visited[cur.x][cur.y]) {
                    answer = Math.min(answer, dist[cur.x][cur.y] + dist[nx][ny]);
                    continue;
                }

                // 바다일 때 퍼짐
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur.x][cur.y]; // 섬 번호 복사
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Data(nx, ny));
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<Data> q = new ArrayDeque<>();
        visited[x][y] = cnt;
        q.offer(new Data(x, y));
        while (!q.isEmpty()) {
            Data data = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 범위
                if (a[nx][ny] == 1 && visited[nx][ny] == 0) { // 장애물 || 방문
                    visited[nx][ny] = cnt;
                    q.offer(new Data(nx, ny));
                }
            }
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 범위
            if (a[nx][ny] == 0) return true;
        }
        return false;
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}