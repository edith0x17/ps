import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map, visited;
    static int sx, sy, tx, ty, ex, ey;

    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    map[i][j] = 0;
                    sx = i;
                    sy = j;
                } else if (ch == 'L') {
                    map[i][j] = 0;
                    tx = i;
                    ty = j;
                } else if (ch == 'E') {
                    map[i][j] = 0;
                    ex = i;
                    ey = j;
                } else if (ch == 'X') {
                    map[i][j] = 1;
                } else if (ch == 'O') {
                    map[i][j] = 0;
                }
            }
        }
        int a = bfs(sx, sy, tx, ty);
        int b = bfs(tx, ty, ex, ey);
        if (a != 0 && b != 0) return a - 1 + b - 1;
        return -1;
    }

    static int bfs(int x, int y, int gx, int gy) {
        visited = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        visited[x][y] = 1;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == gx && cur[1] == gy) return visited[gx][gy];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (map[nx][ny] == 1) continue;
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return 0;
    }
}