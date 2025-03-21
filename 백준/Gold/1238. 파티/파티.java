import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static ArrayList<Data>[] adj;
    static ArrayList<Data>[] reverseAdj;
    static int[] dFromX, dToX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        reverseAdj = new ArrayList[n + 1]; // 역방향 그래프 추가
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, dist));  // 정방향
            reverseAdj[t].add(new Data(f, dist)); // 역방향
        }

        dFromX = dijkstra(x, adj); // X에서 모든 마을
        dToX = dijkstra(x, reverseAdj); // 모든 마을에서 X

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dFromX[i] + dToX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, ArrayList<Data>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Data> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Data(start, 0));

        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int here = data.to;

            if (dist[here] < data.dist) continue;

            for (Data there : graph[here]) {
                if (dist[there.to] > dist[here] + there.dist) {
                    dist[there.to] = dist[here] + there.dist;
                    pq.offer(new Data(there.to, dist[there.to]));
                }
            }
        }
        return dist;
    }

    static class Data implements Comparable<Data> {
        int to, dist;
        public Data(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
        @Override
        public int compareTo(Data o) {
            return this.dist - o.dist;
        }
    }
}