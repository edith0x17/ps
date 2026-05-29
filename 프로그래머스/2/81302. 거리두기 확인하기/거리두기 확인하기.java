import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;

    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for (int k = 0; k < n; k++) {
            map = new int[5][5];
            ArrayList<int[]> adj = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[k][i].charAt(j) == 'P') {
                        map[i][j] = 1;
                        adj.add(new int[]{i, j});
                    } else if (places[k][i].charAt(j) == 'X') map[i][j] = -1;
                }
            }
            boolean flag = false;
            for (int i = 0; i < adj.size(); i++) {
                int[] tmp = adj.get(i);
                if (!bfs(tmp[0], tmp[1])) {
                    flag = true;
                    break;
                }
            }

            if (flag) answer[k] = 0;
            else answer[k] = 1;
        }
        return answer;
    }

    static boolean bfs(int x, int y) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[2] == 2) continue;//거리2까지만 검사, continue(O), break(X) 

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == -1) continue;

                if (map[nx][ny] == 1) return false;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return true;
    }
}