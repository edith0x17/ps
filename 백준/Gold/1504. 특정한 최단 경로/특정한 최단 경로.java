import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Data implements Comparable<Data> {
        int to;
        int distance;

        public Data(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Data o) {
            return this.distance - o.distance;
        }
    }

    static int n, e, v1, v2;
    static ArrayList<Data>[] adj = new ArrayList[804];
    static int[] dp;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 804; i++) {
            adj[i] = new ArrayList<>();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, d));
            adj[t].add(new Data(f, d)); // 양방향 그래프
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int answer1 = go(1, v1) + go(v1, v2) + go(v2, n);
        int answer2 = go(1, v2) + go(v2, v1) + go(v1, n);

        int answer = Math.min(answer1, answer2);

        if (answer >= INF) System.out.println(-1); // 연결 불가 시
        else System.out.println(answer);
    }

    static void init() {
        dp = new int[804];
        for (int i = 0; i < 804; i++) {
            dp[i] = INF;
        }
        pq.clear();
    }

    static int go(int start, int end) {
        init();
        dp[start] = 0;
        pq.add(new Data(start, 0));

        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int here = data.to;

            // 목적지에 도달한 경우
            if (here == end) return dp[end];

            for (Data there : adj[here]) {
                if (dp[there.to] > dp[here] + there.distance) {
                    dp[there.to] = dp[here] + there.distance;
                    pq.add(new Data(there.to, dp[there.to]));
                }
            }
        }

        // 도달할 수 없는 경우 INF 반환
        return dp[end];
    }
}