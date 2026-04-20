import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = -1;
        int[][] dp = new int[41][121];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 0; i < info.length; i++) {
            for (int a = 0; a < 121; a++) {
                if (dp[i][a] == Integer.MAX_VALUE) continue;

                // A가 훔침
                int nextA = a + info[i][0];
                if (nextA < n) {
                    dp[i + 1][nextA] = Math.min(dp[i + 1][nextA], dp[i][a]);
                }

                // B가 훔침
                int nextB = dp[i][a] + info[i][1];
                if (nextB < m) {
                    dp[i + 1][a] = Math.min(dp[i + 1][a], nextB);
                }
            }
        }

        // 답 구하기
        for (int a = 0; a < 121; a++) {
            if (dp[info.length][a] != Integer.MAX_VALUE) {
                return a;
            }
        }
        return -1;
    }
}