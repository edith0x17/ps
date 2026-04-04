import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a, dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            a = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    //1
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            go();
            sb.append("Problem ").append(tc++).append(": ").append(dist[n - 1][n - 1]).append('\n');
        }
        System.out.print(sb);
    }

    static void go() {
        pq.clear();

        //2
        dist[0][0] = a[0][0];
        pq.offer(new Data(0, 0, dist[0][0]));

        //3
        while (!pq.isEmpty()) {
            Data tmp = pq.poll();
            int x = tmp.x, y = tmp.y, weight = tmp.w;

            if (dist[x][y] < weight) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;//범위
                int newDist = dist[x][y] + a[nx][ny];
                if (dist[nx][ny] > newDist) {
                    dist[nx][ny] = newDist;
                    pq.offer(new Data(nx, ny, newDist));
                }
            }
        }
    }

    static class Data implements Comparable<Data> {
        int x, y, w;

        public Data(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.w, o.w);
        }
    }
}