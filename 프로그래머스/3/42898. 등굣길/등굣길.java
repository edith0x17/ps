import java.io.*;
import java.util.*;

class Solution {
    static int[][] dp;
    static int k = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1]; // 1-based index

        // 1. 물웅덩이(장애물) 설정
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1; // 장애물 표시
        }

        // 2. 시작점 초기화
        dp[1][1] = 1; 

        // 3. DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점 or 장애물인 경우 무시
                if (i == 1 && j == 1 || dp[i][j] == -1) continue;

                int up = (i > 1 && dp[i - 1][j] != -1) ? dp[i - 1][j] : 0;
                int left = (j > 1 && dp[i][j - 1] != -1) ? dp[i][j - 1] : 0;

                dp[i][j] = (up + left) % k;
            }
        }
        return dp[n][m]; // (n, m)까지 도달하는 경로 수 반환
    }
}