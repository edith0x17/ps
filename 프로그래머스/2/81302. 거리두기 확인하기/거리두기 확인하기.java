import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static ArrayList<int[]> list;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int k = 0; k < places.length; k++) {
            //places[k]
            map = new int[5][5];
            list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[k][i].charAt(j) == 'P') {
                        map[i][j] = 1;
                        list.add(new int[]{i, j});
                    } else if (places[k][i].charAt(j) == 'X') {
                        map[i][j] = -1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int[] cur = list.get(i);
                if (!bfs(cur[0], cur[1])) {
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

            if (cur[2] == 2) continue;

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