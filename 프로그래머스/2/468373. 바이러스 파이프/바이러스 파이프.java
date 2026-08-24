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
            int start = edge[0], end = edge[1], type = edge[2];
            if (type == 1) {
                adjA[start].add(end);
                adjA[end].add(start);
            } else if (type == 2) {
                adjB[start].add(end);
                adjB[end].add(start);
            } else {
                adjC[start].add(end);
                adjC[end].add(start);
            }
        }
        ret = new int[k];
        int[] arr = new int[]{1, 2, 3};
        go(0, n, infection, k, arr);
        return answer;
    }

    static void bfs(boolean[] infected, ArrayList<Integer>[] adj) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < infected.length; i++) {
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

    static void go(int depth, int n, int infection, int k, int[] arr) {
        if (depth == k) {
            boolean[] infected = new boolean[n + 1];
            infected[infection] = true;
            for (int i : ret) {
                if (i == 1) bfs(infected, adjA);
                else if (i == 2) bfs(infected, adjB);
                else bfs(infected, adjC);
            }
            int cnt = 0;
            for (int i = 0; i < n + 1; i++) {
                if (infected[i]) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for (int i = 0; i < 3; i++) {
            ret[depth] = arr[i];
            go(depth + 1, n, infection, k, arr);
        }
    }
}