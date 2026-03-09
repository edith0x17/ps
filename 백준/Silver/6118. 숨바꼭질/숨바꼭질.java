import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = 1;
        q.offer(1);
        while (!q.isEmpty()) {
            int here = q.poll();

            for (int there : adj[here]) {
                //범위
                if (visited[there] != 0) continue;//방문
                visited[there] = visited[here] + 1;
                q.offer(there);
            }
        }
        int mi = Integer.MIN_VALUE;
        for (int i = 2; i < n + 1; i++) {
            mi = Math.max(mi, visited[i]);
        }
        int ans1 = Integer.MAX_VALUE, ans2 = 0, ans3 = 0;
        for (int i = 2; i < n + 1; i++) {
            if (mi == visited[i]) {
                ans1 = Math.min(ans1, i);
                ans3++;
            }
        }
        System.out.println(ans1 + " " + (mi - 1) + " " + ans3);
    }
}