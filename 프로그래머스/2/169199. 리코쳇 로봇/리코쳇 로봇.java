import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sx, sy, ex, ey;

    public int solution(String[] board) {
        int answer = -1;

        int n = board.length;
        int m = board[0].length();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i].charAt(j) == 'R') {
                    sx = i;
                    sy = j;
                } else if (board[i].charAt(j) == 'G') {
                    ex = i;
                    ey = j;
                } else if (board[i].charAt(j) == 'D') {
                    map[i][j] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {

            int[] tmp = q.poll();

            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];

            if (x == ex && y == ey) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x;
                int ny = y;

                while (true) {

                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if (map[tx][ty] == 1) break;

                    nx = tx;
                    ny = ty;
                }

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt + 1});
            }
        }

        return answer;
    }
}