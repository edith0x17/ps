import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a;
    static boolean[][] result;
    static boolean[][][] visited;
    static Queue<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        result = new boolean[n][m];
        visited = new boolean[n][m][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 9) {
                    result[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        visited[i][j][d] = true;
                        q.offer(new Node(i, j, d));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int dir = node.d;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //범위
            if (visited[nx][ny][dir]) continue; //방문

            result[nx][ny] = true;
            visited[nx][ny][dir] = true;

            int nextDir = go(a[nx][ny], dir);
            if (nextDir != -1) {
                q.offer(new Node(nx, ny, nextDir));
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    static int go(int type, int dir) {
        if (type == 0) return dir;
        if (type == 1) {
            if (dir == 0 || dir == 2) return dir;
            else return -1;
        } else if (type == 2) {
            if (dir == 1 || dir == 3) return dir;
            else return -1;
        } else if (type == 3) {
            if (dir == 0) return 1;
            else if (dir == 1) return 0;
            else if (dir == 2) return 3;
            else if (dir == 3) return 2;
        } else if (type == 4) {
            if (dir == 0) return 3;
            else if (dir == 1) return 2;
            else if (dir == 2) return 1;
            else if (dir == 3) return 0;
        } else if (type == 9) {
            return dir;
        }
        return -1;
    }

    static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}