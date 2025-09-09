import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] map;
    static int up = Integer.MAX_VALUE, down = Integer.MIN_VALUE; //row
    static int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE; //col

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        Queue<Data> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') continue;

                int cnt = 0; //?
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) cnt++;
                    else if (map[nx][ny] == '.') cnt++;
                }
                if (cnt >= 3) q.offer(new Data(i, j));
            }
        }
        while (!q.isEmpty()) { //?
            Data data = q.poll();
            map[data.x][data.y] = '.';
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'X') {
                    up = Math.min(up, i);
                    down = Math.max(down, i);

                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                System.out.printf("%c", map[i][j]);
            }
            System.out.println();
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