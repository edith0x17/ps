import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[5][5]; //1-> , 0->
    static int[] ret = new int[7];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (s.charAt(j) == 'S') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        combi(0, 0);
        System.out.println(answer);
    }

    static void go() {
        boolean[][] temp = new boolean[5][5];
        for (int idx : ret) {
            temp[idx / 5][idx % 5] = true;
        }

        boolean[][] visited = new boolean[5][5];
        Queue<Data> q = new ArrayDeque<>();
        int sx = ret[0] / 5, sy = ret[0] % 5;
        int cnt = 1, sCnt = 0;
        if (map[sx][sy] == 1) sCnt++;
        visited[sx][sy] = true;
        q.offer(new Data(sx, sy));
        while (!q.isEmpty()) {
            Data data = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; //범위
                if (visited[nx][ny]) continue; //방문
                if (!temp[nx][ny]) continue;//장애물
                cnt++;
                if (map[nx][ny] == 1) sCnt++;
                visited[nx][ny] = true;
                q.offer(new Data(nx, ny));
            }
        }
        if (cnt == 7 && sCnt >= 4) answer++;
    }

    static void combi(int depth, int start) {
        if (depth == 7) {
            go();
            return;
        }
        for (int i = start; i < 25; i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1);
        }
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}