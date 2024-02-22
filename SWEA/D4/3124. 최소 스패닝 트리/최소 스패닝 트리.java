import java.util.*;

class Solution {

    static class Edge implements Comparable<Edge> {
        long from, to, c; // int를 long으로 변경

        public Edge(long from, long to, long c) { // int를 long으로 변경
            this.from = from;
            this.to = to;
            this.c = c;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.c, other.c); // int를 long으로 변경
        }
    }

    static long[] p; // int를 long으로 변경

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int tc = 1; tc <= t; tc++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            p = new long[n + 1]; // int를 long으로 변경
            for (int i = 1; i <= n; i++) p[i] = i;

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                long from = scanner.nextLong(); // int를 long으로 변경
                long to = scanner.nextLong(); // int를 long으로 변경
                long c = scanner.nextLong(); // int를 long으로 변경
                edges[i] = new Edge(from, to, c);
            }

            Arrays.sort(edges);

            long ret = 0; // int를 long으로 변경
            for (Edge edge : edges) {
                long t1 = find(edge.from);
                long t2 = find(edge.to);

                if (t1 != t2) {
                    ret += edge.c;
                    union(t1, t2);
                }
            }

            System.out.println("#" + tc + ' ' + ret);
        }

    }

    static long find(long x) { // int를 long으로 변경
        if (x == p[(int)x]) return x; // int를 long으로 변경
        return p[(int)x] = find(p[(int)x]); // int를 long으로 변경
    }

    static void union(long x, long y) { // int를 long으로 변경
        x = find(x); // int를 long으로 변경
        y = find(y); // int를 long으로 변경
        p[(int)y] = (int)x; // int를 long으로 변경
    }
}
