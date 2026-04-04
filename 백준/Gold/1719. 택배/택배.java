import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Data>[] adj;
    static int[][] route;//첫 이동 정점 저장
    static PriorityQueue<Data> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
            adj[t].add(new Data(f, w));
        }

        route = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(route[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Data(start, 0));

        while (!pq.isEmpty()) {
            Data cur = pq.poll();
            int now = cur.t, nowDist = cur.w;
            if (dist[now] < nowDist) continue;
            for (Data nextData : adj[now]) {
                int next = nextData.t, cost = nextData.w;
                int newDist = dist[now] + cost;
                if (dist[next] > newDist) {
                    dist[next] = newDist;
                    //핵심 로직
                    if (now == start) route[start][next] = next;
                    else route[start][next] = route[start][now];
                    pq.offer(new Data(next, newDist));
                }
            }
        }
    }

    static class Data implements Comparable<Data> {
        int t, w;

        public Data(int t, int w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.w, o.w);
        }
    }
}