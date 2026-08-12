import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[104][104];
        for (int[] tmp : rectangle) {//
            int sx = tmp[0] * 2, sy = tmp[1] * 2, ex = tmp[2] * 2, ey = tmp[3] * 2;
            for (int i = sx; i <= ex; i++) {
                for (int j = sy; j <= ey; j++) {
                    map[i][j] = 1;
                }
            }
        }
        for (int[] tmp : rectangle) {//테두리
            int sx = tmp[0] * 2, sy = tmp[1] * 2, ex = tmp[2] * 2, ey = tmp[3] * 2;
            for (int i = sx + 1; i < ex; i++) {
                for (int j = sy + 1; j < ey; j++) {
                    map[i][j] = 0;
                }
            }
        }
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;
        int[][] visited = new int[104][104];
        Queue<int[]> q = new ArrayDeque<>();
        visited[characterX][characterY] = 1;
        q.offer(new int[]{characterX, characterY});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1];
            if (x == itemX && y == itemY) {
                return visited[x][y] / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= 104 || ny < 0 || ny >= 104) continue;
                if (visited[nx][ny] != 0) continue;
                if (map[nx][ny] == 0) continue;
                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return answer;
    }
}