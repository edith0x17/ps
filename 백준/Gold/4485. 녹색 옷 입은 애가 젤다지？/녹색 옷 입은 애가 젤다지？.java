import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Data implements Comparable<Data> {
        int x;
        int y;
        int c;

        public Data(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.c, o.c);
        }
    }

    static int INF = Integer.MAX_VALUE;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int n;
    static int[][] a, d; // d-> 비용
    static boolean[][] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            cnt++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            PriorityQueue<Data> pq = new PriorityQueue<>();
            a = new int[n + 4][n + 4];
            d = new int[n + 4][n + 4];
            visited = new boolean[n + 4][n + 4];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.printf("%d ", a[i][j]);
//                }
//                System.out.println();
//            }

            for (int i = 0; i < n + 4; i++) {

                for (int j = 0; j < n + 4; j++) {
                    d[i][j] = INF;
                }
            }

            d[0][0] = a[0][0];
            pq.offer(new Data(0, 0, d[0][0]));

            int cntV = 0;
            while (!pq.isEmpty()) {
                Data now = pq.poll();

                if(visited[now.x][now.y]) {
                    continue;
                }
                visited[now.x][now.y] = true;

                cntV++;
                if(cntV == n * n){
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

                    if(d[nx][ny] > d[now.x][now.y] + a[nx][ny]){ // direct || bypass
                        d[nx][ny] = d[now.x][now.y] + a[nx][ny];
                        pq.offer(new Data(nx, ny, d[nx][ny])); // push - nx, ny, d[nx][ny]
                    }
                }
            }
            System.out.println("Problem" + " " + cnt + ": " + d[n - 1][n - 1]);

        }
    }
}