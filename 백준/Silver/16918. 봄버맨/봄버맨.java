import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n;
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == 'O') {
                    map[i][j] = 3;
                }
            }
        }

        int time = 0;
        while (time < n) {
            time++;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) {
                        map[i][j]--;
                        if (map[i][j] == 0) {
                            map[i][j] = -1;
                        }
                    }
                }
            }

            if (time % 2 == 0) { //짝수
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == 0) {
                            map[i][j] = 3;
                        }
                    }
                }
            } else { //홀수
                Queue<int[]> q = new ArrayDeque<>();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == -1) {
                            q.offer(new int[]{i, j});
                        }
                    }
                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    map[x][y] = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue; //범위
                        map[nx][ny] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("%c", map[i][j] > 0 ? 'O' : '.');
            }
            System.out.println();
        }
    }
}