import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        int mx = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (result[i] > mx) {
                mx = result[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == mx) sb.append(i).append(" ");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int here = q.poll();
            for (int there : adj[here]) {
                if (!visited[there]) {
                    visited[there] = true;
                    result[start]++;
                    q.add(there);
                }
            }
        }
    }
}