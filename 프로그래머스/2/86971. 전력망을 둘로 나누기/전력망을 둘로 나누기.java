import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    ;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for (int j = 0; j < n + 1; j++) {
                adj[j] = new ArrayList<>();
            }
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int f = wires[j][0];
                int t = wires[j][1];
                adj[f].add(t);
                adj[t].add(f);
            }
            visited = new boolean[n + 1];
            int cnt = dfs(1, adj);
            int diff = Math.abs(cnt - (n - cnt));
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    static int dfs(int here, ArrayList<Integer>[] adj) {
        int ret = 1;
        visited[here] = true;
        for (int there : adj[here]) {
            if (visited[there]) continue;
            ret += dfs(there, adj);
        }
        return ret;
    }
}