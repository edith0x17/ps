import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, sx, sy, lx, ly, ex, ey;
    static int[][] a;

    public int solution(String[] maps) {
        n = maps.length; m = maps[0].length();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    lx = i;
                    ly = j;
                } else if (c == 'E') {
                    ex = i;
                    ey = j;
                } else if (c == 'X') {
                    a[i][j] = 1;
                }
            }
        }

        int d1 = bfs(sx, sy, lx, ly);
        if (d1 == -1) return -1;

        int d2 = bfs(lx, ly, ex, ey);
        if (d2 == -1) return -1;

        return d1 + d2;
    }

    static int bfs(int sx, int sy, int tx, int ty) {
        int[][] visited = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sx, sy});
        visited[sx][sy] = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1];
            if (x == tx && y == ty) return visited[x][y] - 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (a[nx][ny] == 1) continue;
                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}