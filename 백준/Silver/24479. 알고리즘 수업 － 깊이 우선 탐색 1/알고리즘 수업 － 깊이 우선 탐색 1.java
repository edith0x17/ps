import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, order = 1;
    static boolean[] visited;
    static int[] result;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[n + 1];
        result = new int[n + 1];

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        result[now] = order++;
        for (int next : adj[now]) {
            if (!visited[next]) dfs(next);
        }
    }
}