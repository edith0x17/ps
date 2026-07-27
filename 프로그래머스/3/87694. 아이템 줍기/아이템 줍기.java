import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[104][104];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for (int[] tmp : rectangle) {
            int sx = tmp[0] * 2, sy = tmp[1] * 2, ex = tmp[2] * 2, ey = tmp[3] * 2;
            for (int i = sx; i <= ex; i++) {
                for (int j = sy; j <= ey; j++) {
                    map[i][j] = 1;
                }
            }
        }
        for (int[] tmp : rectangle) {
            int sx = tmp[0] * 2, sy = tmp[1] * 2, ex = tmp[2] * 2, ey = tmp[3] * 2;
            for (int i = sx + 1; i < ex; i++) {
                for (int j = sy + 1; j < ey; j++) {
                    map[i][j] = 0;
                }
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        int[][] visited = new int[104][104];
        Queue<int[]> q = new ArrayDeque<>();
        visited[characterX][characterY] = 1;
        q.offer(new int[]{characterX, characterY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == itemX && cur[1] == itemY) {
                return visited[cur[0]][cur[1]] / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= 104 || ny < 0 || ny >= 104) continue;
                if (visited[nx][ny] != 0) continue;
                if (map[nx][ny] == 0) continue;
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return answer;
    }
}