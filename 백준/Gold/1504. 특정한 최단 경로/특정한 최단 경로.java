import java.io.*;
import java.util.*;

public class Main {
    static int n, e, v1, v2;
    static ArrayList<Data>[] adj;
    static int[] distS, distV1, distV2;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        distS = new int[n + 1];
        distV1 = new int[n + 1];
        distV2 = new int[n + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, w));
            adj[t].add(new Data(f, w));//양방향
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            distS[i] = Integer.MAX_VALUE;
            distV1[i] = Integer.MAX_VALUE;
            distV2[i] = Integer.MAX_VALUE;
        }
        go(1, distS);
        go(v1, distV1);
        go(v2, distV2);
        long case1 = (long) distS[v1] + distV1[v2] + distV2[n];
        long case2 = (long) distS[v2] + distV2[v1] + distV1[n];
        long ans = Math.min(case1, case2);
        if (distS[v1] == Integer.MAX_VALUE || distV1[v2] == Integer.MAX_VALUE || distV2[n] == Integer.MAX_VALUE) {
            case1 = Long.MAX_VALUE;
        }
        if (distS[v2] == Integer.MAX_VALUE || distV2[v1] == Integer.MAX_VALUE || distV1[n] == Integer.MAX_VALUE) {
            case2 = Long.MAX_VALUE;
        }
        ans = Math.min(case1, case2);
        if (ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void go(int s, int[] dist) {
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