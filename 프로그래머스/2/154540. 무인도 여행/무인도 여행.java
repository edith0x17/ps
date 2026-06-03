import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;
    static Queue<int[]> q;

    public int[] solution(String[] maps) {
        int n = maps.length, m = maps[0].length();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'X') map[i][j] = -1;
                else if (ch >= '1' && ch <= '9') map[i][j] = ch - '0';
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        visited = new boolean[n][m];
        q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1 && !visited[i][j]) {
                    int tmp = bfs(i, j, n, m, map);
                    if (tmp != 0) ret.add(tmp);
                }
            }
        }
        int[] answer = new int[ret.size()];
        if (ret.size() == 0) return new int[]{-1};
        else {
            for (int i = 0; i < ret.size(); i++) {
                answer[i] = ret.get(i);
            }
            Arrays.sort(answer);
        }
        return answer;
    }

    static int bfs(int x, int y, int n, int m, int[][] map) {
        int ret = map[x][y];

        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == -1) continue;
                ret += map[nx][ny];
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }

        }
        return ret;
    }
}