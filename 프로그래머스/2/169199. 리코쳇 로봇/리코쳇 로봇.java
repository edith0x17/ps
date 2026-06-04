import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map, visited;
    static int sx, sy, ex, ey;

    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);
                if (ch == '.') {
                    map[i][j] = 0;
                } else if (ch == 'D') {
                    map[i][j] = 1;
                } else if (ch == 'R') {
                    map[i][j] = 0;
                    sx = i;
                    sy = j;
                } else if (ch == 'G') {
                    map[i][j] = 0;
                    ex = i;
                    ey = j;
                }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = 1;
        q.offer(new int[]{sx, sy});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == ex && cur[1] == ey) return visited[ex][ey] - 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];

                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if (map[tx][ty] == 1) break;
                    nx = tx;
                    ny = ty;
                }
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}