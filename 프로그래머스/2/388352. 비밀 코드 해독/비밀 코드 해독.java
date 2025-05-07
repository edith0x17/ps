import java.util.*;

class Solution {
    static int n, answer;
    static int[][] q;
    static int[] ans;
    static int[] ret = new int[5];

    public int solution(int n_, int[][] q_, int[] ans_) {
        n = n_;
        q = q_;
        ans = ans_;
        answer = 0;
        combi(0, 1);
        return answer;
    }

    static void combi(int depth, int start) {
        if (depth == 5) {
            if (check()) answer++;
            return;
        }
        for (int i = start; i <= n; i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1);
        }
    }

    static boolean check() {
        Set<Integer> code = new HashSet<>();
        for (int num : ret) code.add(num);

        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int num : q[i]) {
                if (code.contains(num)) cnt++;
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }
}