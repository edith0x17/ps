import java.io.*;
import java.util.*;

public class Main {
    static final int[][] attacks = new int[][]{
            {9, 3, 1},
            {9, 1, 3},
            {3, 1, 9},
            {3, 9, 1},
            {1, 3, 9},
            {1, 9, 3}
    };
    static int n;
    static int[] a = new int[3];
    static int[][][] visited = new int[64][64][64];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        bfs(a[0], a[1], a[2]);
        System.out.println(visited[0][0][0] - 1);
    }

    static void bfs(int a, int b, int c) {
        Queue<Data> q = new ArrayDeque<>();
        
        visited[a][b][c] = 1;
        q.offer(new Data(a, b, c));
        while (!q.isEmpty()) {
            Data data = q.poll();

            if (visited[0][0][0] != 0) break; // 장애물

            for (int i = 0; i < 6; i++) {
                int na = Math.max(0, data.x - attacks[i][0]);
                int nb = Math.max(0, data.y - attacks[i][1]);
                int nc = Math.max(0, data.z - attacks[i][2]);

                if (visited[na][nb][nc] != 0) continue; // 장애물
                
                visited[na][nb][nc] = visited[data.x][data.y][data.z] + 1;
                q.offer(new Data(na, nb, nc));
            }
        }
    }

    static class Data {
        int x, y, z;

        public Data(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}