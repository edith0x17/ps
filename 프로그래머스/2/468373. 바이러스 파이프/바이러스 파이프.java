import java.util.*;

class Solution {
    static int answer;
    static ArrayList<Integer>[] adjA, adjB, adjC;
    static int[] ret;

    public int solution(int n, int infection, int[][] edges, int k) {
        adjA = new ArrayList[n + 1];
        adjB = new ArrayList[n + 1];
        adjC = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjA[i] = new ArrayList<>();
            adjB[i] = new ArrayList<>();
            adjC[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], pipe = edge[2];
            if (pipe == 1) {
                adjA[from].add(to);
                adjA[to].add(from);
            } else if (pipe == 2) {
                adjB[from].add(to);
                adjB[to].add(from);
            } else {
                adjC[from].add(to);
                adjC[to].add(from);
            }
        }

        int[] tmp = new int[]{1, 2, 3};
        ret = new int[k];
        go(0, n, infection, k, tmp);
        return answer;
    }

    static void bfs(boolean[] infected, ArrayList<Integer>[] adj, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            if (infected[i]) q.offer(i);
        }

        while (!q.isEmpty()) {
            int here = q.poll();

            for (int there : adj[here]) {
                if (infected[there]) continue;

                infected[there] = true;
                q.offer(there);
            }
        }
    }

    static void go(int depth, int n, int infection, int k, int[] tmp) {//중복순열
        if (depth == k) {
            boolean[] infected = new boolean[n + 1];
            infected[infection] = true;
            for (int pipe : ret) {
                if (pipe == 1) bfs(infected, adjA, n);
                else if (pipe == 2) bfs(infected, adjB, n);
                else bfs(infected, adjC, n);
            }
            int cnt = 0;
            for (int i = 0; i < n + 1; i++) {
                if (infected[i]) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for (int i = 0; i < 3; i++) {
            ret[depth] = tmp[i];
            go(depth + 1, n, infection, k, tmp);
        }
    }
}