import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map = new int[1004][1004];
    static int[][] visited = new int[1004][1004];
    static boolean flag;
    static Queue<Data> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) flag = true; // check1

                if (map[i][j] == 1) { // 토마토 익음

                    q.add(new Data(i, j));
                    visited[i][j] = 1;

                }
            }
        }

        if (flag) { // 안익음
            go();
            
            int ret = check();
            if (ret != -1) { // 다익음
                System.out.println(ret);
            } else { // 안익음
                System.out.println(-1);
            }
        } else { // 다익음
            System.out.println(0);
        }


    }

    static int check() { // 익음 안익음 체크
        int max = -987654321;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) return -1;
                max = Math.max(max, visited[i][j]);
            }
        }
        return max - 1;
    }

    static void go() {
        // 큐, push, visit

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] != 0) continue; // 범위 || 방문

                if (map[nx][ny] == 1 || map[nx][ny] == -1) continue; // 토마토 익음 || 토마토 없음 -> 방문X

                if (map[nx][ny] == 0) { // 토마토 익지않음
                    map[nx][ny] = 1; //  -> 토마토 익음
                    
                    q.add(new Data(nx, ny)); // -> push
                    visited[nx][ny] = visited[x][y] + 1; // -> visit
                }


            }
        }

    }

    static class Data {
        int x;
        int y;

        public Data() {
        }

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}