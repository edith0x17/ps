import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int n, r1, c1, r2, c2;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        Queue<Data> q = new ArrayDeque<>();
        visited = new int[n][n];

        visited[r1][c1] = 1;
        q.offer(new Data(r1, c1));
        while (!q.isEmpty()) {
            Data data = q.poll();
            if (data.r == r2 && data.c == c2) break;
            for (int i = 0; i < 6; i++) {
                int nr = data.r + dr[i];
                int nc = data.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc] != 0) continue;
                visited[nr][nc] = visited[data.r][data.c] + 1;
                q.offer(new Data(nr, nc));
            }
        }
        if (visited[r2][c2] == 0) System.out.println(-1);
        else System.out.println(visited[r2][c2] - 1);
    }

    static class Data {
        int r, c;

        public Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}