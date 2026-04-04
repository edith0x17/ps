import java.io.*;
import java.util.*;

public class Main {
    static int v, e, k;
    static ArrayList<Data>[] adj;
    static int[] dist;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        dist = new int[v + 1];
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
        }
        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        pq.offer(new Data(k, 0));
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
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v + 1; i++) {
            if (i == k) sb.append(0 + "\n");
            else if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
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