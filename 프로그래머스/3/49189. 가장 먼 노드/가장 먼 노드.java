import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] tmp : edge) {
            int f = tmp[0];
            int t = tmp[1];

            adj[f].add(t);
            adj[t].add(f);
        }

        visited = new boolean[n + 1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        int mx = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int here = cur[0];
            int dist = cur[1];

            if (dist > mx) {
                mx = dist;
                cnt = 1;
            } else if (dist == mx) {
                cnt++;
            }

            for (int there : adj[here]) {
                if (visited[there]) continue;

                visited[there] = true;
                q.offer(new int[]{there, dist + 1});
            }
        }

        answer = cnt;

        return answer;
    }
}