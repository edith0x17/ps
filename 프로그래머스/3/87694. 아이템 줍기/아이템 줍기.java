import java.util.*;

class Solution {
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // ⛳ 맵 초기화
        for (int i = 0; i < 102; i++) {
            Arrays.fill(map[i], -1); // ❗ 반드시 -1로 초기화
        }

        // 📦 사각형 처리
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    // 내부
                    if (x1 < i && i < x2 && y1 < j && j < y2) {
                        map[i][j] = 0;
                    }
                    // 테두리 (내부가 아닐 때만)
                    else if (map[i][j] != 0) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        // 🎯 BFS
        Queue<int[]> q = new LinkedList<>();
        int sx = characterX * 2;
        int sy = characterY * 2;
        int ex = itemX * 2;
        int ey = itemY * 2;

        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == ex && y == ey) return dist / 2;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1; // 실패
    }
}