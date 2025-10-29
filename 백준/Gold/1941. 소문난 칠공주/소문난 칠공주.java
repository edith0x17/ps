import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static char[][] map = new char[5][5];
    static int[] ret = new int[7];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        combi(0, 0);
        System.out.println(answer);
    }

    static void go() {
        boolean[][] selected = new boolean[5][5];
        for (int idx : ret) {
            selected[idx / 5][idx % 5] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        int sx = ret[0] / 5, sy = ret[0] % 5, cnt = 1, sCnt = 0;
        if (map[sx][sy] == 'S') sCnt++;
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] here = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = here[0] + dx[i];
                int ny = here[1] + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; //범위
                if (visited[nx][ny]) continue; //방문
                if (!selected[nx][ny]) continue; //장애물
                cnt++;
                if (map[nx][ny] == 'S') sCnt++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        if (cnt == 7 && sCnt >= 4) answer++;
    }

    static void combi(int depth, int start) {
        if (depth == 7) {
            go(); //ret -> 7 && x >= 4
            return;
        }

        for (int i = start; i < 25; i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1);
        }
    }
}