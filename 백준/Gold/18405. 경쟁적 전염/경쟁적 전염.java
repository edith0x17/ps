import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, k;
    static int[][] a;
    static boolean[][] visited;
    static int s, sx, sy;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] != 0){
                    visited[i][j] = true;
                    pq.offer(new Data(a[i][j], i, j));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        int t = 0;
        while (t < s) {
            int size = pq.size();
            PriorityQueue<Data> nextPq = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                Data data = pq.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = data.x + dx[d];
                    int ny = data.y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    a[nx][ny] = data.num;
                    nextPq.offer(new Data(data.num, nx, ny));
                }
            }
            pq = nextPq;
            t++;
        }
//        for(int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(a[i]));
//        }
        System.out.println(a[sx][sy]);
    }
    static class Data implements Comparable<Data>{
        int num;
        int x, y;
        public Data(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Data o){
            return Integer.compare(this.num, o.num);// asc
        }
    }
}