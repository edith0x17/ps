import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static int sx, sy, ex, ey;

    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == '.') a[i][j] = 0;
                else if (board[i].charAt(j) == 'R') {
                    a[i][j] = 0;
                    sx = i;
                    sy = j;
                } else if (board[i].charAt(j) == 'G') {
                    a[i][j] = 0;
                    ex = i;
                    ey = j;
                } else if (board[i].charAt(j) == 'D') a[i][j] = 1;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1], cnt = tmp[2];

            if (x == ex && y == ey) {
                answer = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x, ny = y;
                while (true) {
                    int tx = nx + dx[i], ty = ny + dy[i];
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if (a[tx][ty] == 1) break;
                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return answer;
    }
}