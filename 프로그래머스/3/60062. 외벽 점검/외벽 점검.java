import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    static int[] weak2;
    static boolean[] visited;
    static int[] ret;

    public int solution(int n, int[] weak, int[] dist) {
        weak2 = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            weak2[i] = weak[i];
        }
        for (int i = weak.length; i < weak2.length; i++) {
            weak2[i] = weak[i - weak.length] + n;
        }
        visited = new boolean[dist.length];
        ret = new int[dist.length];
        go(0, weak, dist);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static void check(int[] weak, int[] dist, int[] order) {
        for (int start = 0; start < weak.length; start++) {
            int friendIdx = 0;
            int cover = weak2[start] + order[friendIdx];
            boolean possible = true;
            for (int i = start; i < start + weak.length; i++) {
                if (weak2[i] > cover) {
                    friendIdx++;
                    if (friendIdx == order.length) {
                        possible = false;
                        break;
                    }
                    cover = weak2[i] + order[friendIdx];
                }
            }
            if (possible) {
                ans = Math.min(ans, friendIdx + 1);
            }
        }
    }

    static void go(int depth, int[] weak, int[] dist) {
        if (depth == dist.length) {
            int[] order = new int[ret.length];
            for (int i = 0; i < ret.length; i++) {
                order[i] = dist[ret[i]];
            }
            check(weak, dist, order);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ret[depth] = i;
            go(depth + 1, weak, dist);
            visited[i] = false;
        }
    }
}