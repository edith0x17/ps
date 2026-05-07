import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length, m = maps[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        visited[0][0] = 1;
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1];
            if (x == n - 1 && y == m - 1) {
                if (visited[x][y] != 0) return visited[x][y];
                else return -1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                if (maps[nx][ny] == 0) continue;
                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return answer;
    }
}