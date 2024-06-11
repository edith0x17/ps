import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt; //
    static int x, y;
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 4];
        for (int i = 0; i < n + 4; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new int[n + 4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int t, f;
            t = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());

            adj[t].add(f);
            adj[f].add(t);
        }

        bfs(x);

        if (visited[y] != 0) {
            System.out.println(visited[y] - 1); // start is counting...
        } else {
            System.out.println(-1);
        }

    }

    static void bfs(int start) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int qSize = q.size();

            // if (start == end) return;

            while (qSize-- != 0) {
                start = q.poll(); // front(), pop()

                for (int middle : adj[start]) {
                    if (visited[middle] != 0) continue;

                    q.add(middle);
                    visited[middle] = visited[start] + 1;
                }
            }

            cnt++;
        }
    }

    static class Data {
        int a;
        int b;

        public Data() {
        }

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}