import java.util.*;

class Solution {
    static ArrayList<int[]>[] graph;
    static int[] d;

    public int solution(int n, int[][] road, int k) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            int from = r[0], to = r[1], dist = r[2];
            graph[from].add(new int[]{to, dist});
            graph[to].add(new int[]{from, dist});
        }

        d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        d[1] = 0;//d[there] = 지금까지 알고 있던 1 → there 최단거리
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int here = cur[0], hereDist = cur[1];//hereDist = 시작점 1 → here까지의 누적 거리

            if (d[here] < hereDist) continue;

            for (int[] next : graph[here]) {
                int there = next[0], thereDist = next[1];//thereDist = here → there의 간선 거리
                if (d[there] > hereDist + thereDist) {
                    d[there] = hereDist + thereDist;
                    pq.offer(new int[]{there, hereDist + thereDist});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] <= k) answer++;
        }
        return answer;
    }
}