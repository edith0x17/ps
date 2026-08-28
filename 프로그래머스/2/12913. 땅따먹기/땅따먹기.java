import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            // 이전 행에서 내가 있었던 열
            for (int prev = 0; prev < 4; prev++) {
                // 현재 행에서 갈 열
                for (int next = 0; next < 4; next++) {
                    if (prev == next) continue;

                    dp[i][next] = Math.max(dp[i][next], dp[i - 1][prev] + land[i][next]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        return answer;
    }
}