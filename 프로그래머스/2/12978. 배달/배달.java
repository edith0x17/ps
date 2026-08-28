import java.util.*;

class Solution {
    static ArrayList<int[]>[] adj;

    public int solution(int n, int[][] road, int k) {
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            int s = r[0], e = r[1], dist = r[2];
            adj[s].add(new int[]{e, dist});
            adj[e].add(new int[]{s, dist});
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        d[1] = 0;
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int here = cur[0], hereDist = cur[1];

            if (d[here] < hereDist) continue;

            for (int[] tmp : adj[here]) {
                int there = tmp[0], thereDist = tmp[1];
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