import java.io.*;
import java.util.*;

public class Main {
    static int v, e, start;
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
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
        }
        //초기화
        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        pq.add(new Data(start, 0));
        while (!pq.isEmpty()) {
            Data tmp = pq.poll();
            int here = tmp.t, weight = tmp.w;
            if (dist[here] < weight) continue;//
            for (Data data : adj[here]) {
                int next = data.t, nextWeight = data.w;
                if (dist[next] > dist[here] + nextWeight) {
                    dist[next] = dist[here] + nextWeight;
                    pq.offer(new Data(next, dist[here] + nextWeight));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
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