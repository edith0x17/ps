import java.util.*;

class Solution {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static int[] colOil;

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        a = land;
        visited = new boolean[n][m];
        colOil = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    Set<Integer> set = new HashSet<>();
                    int size = bfs(new Data(i, j), set);
                    for (int col : set) {
                        colOil[col] += size;
                    }
                }
            }
        }

        int answer = 0;
        for (int val : colOil) {
            answer = Math.max(answer, val);
        }
        return answer;
    }

    static int bfs(Data start, Set<Integer> set) {
        Queue<Data> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        set.add(start.y);
        int ret = 1;

        while (!q.isEmpty()) {
            Data cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (a[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                set.add(ny);
                q.offer(new Data(nx, ny));
                ret++;
            }
        }

        return ret;
    }
}