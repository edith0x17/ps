import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] ret;
    static int answer;
    static int N;
    static int[] Weak;
    static int[] Weak2;

    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;

        N = n;
        Weak = weak;

        visited = new boolean[dist.length];
        ret = new int[dist.length];

        Weak2 = new int[weak.length * 2];

        for (int i = 0; i < weak.length; i++) {
            Weak2[i] = weak[i];
        }

        for (int i = weak.length; i < weak.length * 2; i++) {
            Weak2[i] = weak[i - weak.length] + n;
        }

        go(0, dist);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static void check(int[] order) {

        for (int start = 0; start < Weak.length; start++) {//1, 5, 6, 10
            int friendIdx = 0;
            int cover = Weak2[start] + order[friendIdx];

            for (int i = start; i < start + Weak.length; i++) {
                if (Weak2[i] > cover) {
                    friendIdx++;

                    if (friendIdx == order.length) break;
                    
                    cover = Weak2[i] + order[friendIdx];
                }
            }

            // friendIdx는 0부터 시작하니까 사용 친구 수는 +1
            if (friendIdx < order.length) {
                answer = Math.min(answer, friendIdx + 1);
            }
        }
    }

    static void go(int depth, int[] dist) {

        if (depth == dist.length) {

            int[] order = new int[dist.length];

            for (int i = 0; i < dist.length; i++) {
                order[i] = dist[ret[i]];
            }

            check(order);

            return;
        }

        for (int i = 0; i < dist.length; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            ret[depth] = i;

            go(depth + 1, dist);

            visited[i] = false;
        }
    }
}