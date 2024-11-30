import java.io.*;
import java.util.*;

public class Main {
    static class Data {
        int x, y, z;
        public Data(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int l, r, c;
    static char[][][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            map = new char[l][r][c];
            visited = new int[l][r][c];
            Data start = null;
            Data end = null;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = s.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start = new Data(i, j, k);
                        } else if (map[i][j][k] == 'E') {
                            end = new Data(i, j, k);
                        }
                    }
                }
                br.readLine(); // 빈 줄 처리
            }

            int result = bfs(start, end);
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    static int bfs(Data start, Data end) {
        Queue<Data> q = new ArrayDeque<>();
        visited[start.x][start.y][start.z] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            Data here = q.poll();
            int x = here.x, y = here.y, z = here.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) continue; // 범위 초과
                if (map[nx][ny][nz] == '#' || visited[nx][ny][nz] > 0) continue; // 벽이거나 이미 방문
                if (map[nx][ny][nz] == 'E') { // 출구 발견
                    return visited[x][y][z];
                }

                visited[nx][ny][nz] = visited[x][y][z] + 1;
                q.offer(new Data(nx, ny, nz));
            }
        }

        return -1; // 탈출 불가
    }
}