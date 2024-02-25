import java.util.*;

class Main {

    static class Edge implements Comparable<Edge> {
        int from, to, c;

        public Edge(int from, int to, int c) {
            this.from = from;
            this.to = to;
            this.c = c;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.c, other.c);
        }
    }

    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int c = scanner.nextInt();
            edges[i] = new Edge(from, to, c);
        }

        Arrays.sort(edges);

        int ret = 0;
        for (Edge edge : edges) {
            int t1 = find(edge.from);
            int t2 = find(edge.to);

            if (t1 != t2) {
                ret += edge.c;
                union(t1, t2);
            }
        }

        System.out.println(ret);
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        p[y] = p[x];
    }
}
