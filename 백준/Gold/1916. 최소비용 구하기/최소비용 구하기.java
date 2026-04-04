import java.io.*;
import java.util.*;

public class Main {
    static int n, m, s, e;
    static ArrayList<Data>[] adj;
    static int[] dist;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        pq.offer(new Data(s, 0));
        while (!pq.isEmpty()) {
            Data tmp = pq.poll();
            int now = tmp.t, nowWeight = tmp.w;
            if (dist[now] < nowWeight) continue;
            for (Data data : adj[now]) {
                int next = data.t, nextWeight = data.w;
                if (dist[next] > dist[now] + nextWeight) {
                    dist[next] = dist[now] + nextWeight;
                    pq.offer(new Data(next, dist[now] + nextWeight));
                }
            }
        }
        System.out.println(dist[e]);
    }

    static class Data implements Comparable<Data> {
        int t, w;

        public Data(int t, int w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.w, o.w);//오름차순
        }
    }
}