import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static int k;
    static ArrayList<A>[] adj; // {to, c}
    static int[] d = new int[20001];
    static PriorityQueue<A> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
    static int INF = Integer.MAX_VALUE;

    static class A implements Comparable<A> {
        int to;
        int c;

        public A(int to, int c) {
            this.to = to;
            this.c = c;
        }

        @Override
        public int compareTo(A o) {
            return Integer.compare(this.c, this.c);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        adj = new ArrayList[v + 4];
        for (int i = 0; i < v + 4; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            adj[x].add(new A(y, z)); // 단방향
        }

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) bw.write("INF\n");
            else bw.write(d[i] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    static void dijkstra(int start) {

        for (int i = 0; i < 20001; i++) d[i] = INF; // INF

        d[start] = 0;
        pq.add(new A(start, 0));

        while (!pq.isEmpty()) {

            A here = pq.poll(); // front, pop

            for (A next : adj[here.to]) {
                if (d[next.to] > d[here.to] + next.c) { // direct || bypass
                    d[next.to] = d[here.to] + next.c;
                    pq.add(new A(next.to, d[next.to]));
                }
            }
        }
    }
}