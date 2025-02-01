import java.io.*;
import java.util.*;

public class Main {
    static class Data {
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, l, r, answer;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // init
            visited = new boolean[n][n];
            flag = false;

            // logic
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    ArrayList<Data> ret = dfs(i, j);
                    if (ret.size() > 1) { // 연합이 형성된 경우만
                        flag = true;
                        int sum = 0;
                        for (Data data : ret) {
                            sum += map[data.x][data.y];
                        }
                        for (Data data : ret) {
                            map[data.x][data.y] = sum / ret.size();
                        }
                    }
                }
            }
            if (flag) answer++;
            else break;
        }
        sb.append(answer);
        bw.write(sb+ "");
        bw.flush();
        bw.close();
    }

    static ArrayList<Data> dfs(int x, int y) {
        ArrayList<Data> ret = new ArrayList<>();

        visited[x][y] = true;
        ret.add(new Data(x, y)); // ✅ 현재 위치를 먼저 추가

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
            int temp = Math.abs(map[x][y] - map[nx][ny]);

            if (l <= temp && temp <= r) {
                ret.addAll(dfs(nx, ny)); // ✅ 재귀 호출을 통해 연결된 모든 위치 추가
            }
        }
        return ret;
    }

    static ArrayList<Data> bfs(int x, int y) {
        ArrayList<Data> ret = new ArrayList<>();
        ArrayDeque<Data> queue = new ArrayDeque<>();
        ret.add(new Data(x, y));// 현재 추가
        visited[x][y] = true;
        queue.offer(new Data(x, y));
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;// 범위 || 방문

                int temp = Math.abs(map[data.x][data.y] - map[nx][ny]);
                if (l <= temp && temp <= r) {
                    ret.add(new Data(nx, ny));// 나중 추가
                    visited[nx][ny] = true;
                    queue.offer(new Data(nx, ny));
                }
            }
        }
        return ret;
    }
}