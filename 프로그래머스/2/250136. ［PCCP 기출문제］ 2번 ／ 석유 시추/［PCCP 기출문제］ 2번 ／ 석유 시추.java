import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public int solution(int[][] land) {//0이면 빈 땅을, 1이면 석유
        int answer = 0, n = land.length, m = land[0].length;
        visited = new boolean[n][m];
        int[] colOil = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Set<Integer> set = new HashSet<>();
                    int size = bfs(i, j, set, land, n, m);
                    for (int col : set) {
                        colOil[col] += size;
                    }
                }
            }
        }
        for (int val : colOil) {
            answer = Math.max(answer, val);
        }
        return answer;
    }

    static int bfs(int x, int y, Set<Integer> set, int[][] land, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();

        set.add(y);
        int ret = 1;
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (land[nx][ny] == 0) continue;
                set.add(ny);
                ret++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return ret;
    }
}