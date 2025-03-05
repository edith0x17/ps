import java.io.*;
import java.util.*;

public class Main {
    static int n, m, s, e;
    static ArrayList<Data>[] adj;
    static int[] d, prev; // prev 배열 추가
    static PriorityQueue<Data> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        prev = new int[n + 1]; // 경로 저장을 위한 prev 배열

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, distance));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dijkstra(s);
        System.out.println(d[e]); // 최소 비용 출력
        printPath(e); // 경로 출력
    }
    static void dijkstra(int start) {
        d[start] = 0;
        pq.offer(new Data(start, 0));
        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int here = data.to;

            if (d[here] < data.distance) continue;

            for (Data there : adj[here]) {
                if (d[there.to] > d[here] + there.distance) {
                    d[there.to] = d[here] + there.distance;

                    prev[there.to] = here; // 부모 노드 저장

                    pq.offer(new Data(there.to, d[there.to]));
                }
            }
        }
    }
    static void printPath(int end) {
        Stack<Integer> path = new Stack<>();
        int node = end;
        while (node != 0) { // 시작 노드까지 추적
            path.push(node);
            node = prev[node];
        }

        System.out.println(path.size()); // 경로 개수 출력
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " "); // 경로 출력
        }
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