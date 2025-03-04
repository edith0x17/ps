import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m, k, x;
    static ArrayList<Data>[] adj;
    static int[] d;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        d = new int[n + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(new Data(to, 1));
        }
        d[x] = 0;
        pq.offer(new Data(x, 0));
        while (!pq.isEmpty()) {
            Data current = pq.poll();
            int here = current.to;
            int distance = current.distance;

            if (d[here] < distance) continue;// ?

            for (Data next : adj[here]) {
                int there = next.to;
                int newDist = d[here] + next.distance;

                if (d[there] > newDist) {// 직빵 > 우회
                    d[there] = newDist;
                    pq.offer(new Data(there, newDist));
                }
            }
        }

        // 최단 거리가 정확히 K인 도시 출력
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                sb.append(i).append("\n");
                found = true;
            }
        }
        System.out.println(found ? sb : "-1");
    }

    static class Data implements Comparable<Data> {
        int to, distance;
        public Data(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
        @Override
        public int compareTo(Data o) {
            return this.distance - o.distance;
        }
    }
}