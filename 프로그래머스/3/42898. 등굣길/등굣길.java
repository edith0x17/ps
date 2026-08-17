import java.util.*;

class Solution {
    static int INF = Integer.MAX_VALUE;
    static int mod = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            dp[y][x] = INF;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                }

                else if (dp[i][j] == INF) {
                    dp[i][j] = 0;
                }

                else {
                    dp[i][j] =
                            (dp[i][j - 1] + dp[i - 1][j]) % mod;
                }
            }
        }

        return dp[n][m];
    }
}