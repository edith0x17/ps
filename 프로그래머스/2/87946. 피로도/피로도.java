import java.util.*;

class Solution {
    static int ans;
    static boolean[] visited;
    static int[] ret;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        ret = new int[dungeons.length];
        go(0, k, dungeons);
        return ans;
    }

    static void go(int depth, int k, int[][] dungeons) {
        if (depth == dungeons.length) {
            int tmp = 0;
            for (int i = 0; i < ret.length; i++) {
                if (dungeons[ret[i]][0] > k) break;
                k -= dungeons[ret[i]][1];
                tmp++;
            }
            ans = Math.max(ans, tmp);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ret[depth] = i;
            go(depth + 1, k, dungeons);
            visited[i] = false;
        }
    }
}