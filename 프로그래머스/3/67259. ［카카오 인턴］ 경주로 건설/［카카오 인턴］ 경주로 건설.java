import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length, m = board[0].length;
        int[][][] visited = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, -1, 0});//x, y, dir, price
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1], dir = tmp[2], price = tmp[3];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1) continue;
                int nextPrice = price;
                if (dir == -1 || dir == i) nextPrice += 100;
                else nextPrice += 600;
                if (nextPrice < visited[nx][ny][i]) {
                    visited[nx][ny][i] = nextPrice;
                    q.offer(new int[]{nx, ny, i, nextPrice});
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, visited[n - 1][m - 1][i]);
        }
        return answer;
    }
}