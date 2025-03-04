import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, D;
    static ArrayList<Data>[] adj;
    static int[] d;
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            adj[i] = new ArrayList<>();
        }
        //기본 고속도로 설정 (1칸씩 이동하는 도로 추가)
        for (int i = 0; i < D; i++) {
            adj[i].add(new Data(i + 1, 1)); // i에서 i+1로 가는 기본 도로
        }
        d = new int[D + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (t > D) continue;
            adj[f].add(new Data(t, distance));
        }
        d[0] = 0;
        pq.offer(new Data(0, 0));
        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int here = data.to; // 시작노드에서 data.to노드
            int distance = data.distance; // 시작 노드에서 data.to까지 거리

            if (d[here] < distance) continue;

            for (Data there : adj[here]) {
                int newDist = d[here] + there.distance;
                if (d[there.to] > newDist) { // 직빵 > 우회
                    d[there.to] = newDist;
                    pq.offer(new Data(there.to, newDist));
                }
            }
        }
        System.out.println(d[D]);
    }

    static class Data implements Comparable<Data> {
        int to, distance;
        // 현재 노드 `here`에서 목적지 `to`까지 이동하는데 걸리는 거리 `distance`
        // 시작 노드에서 here까지의 최단 거리 -> Data data = pq.poll();
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