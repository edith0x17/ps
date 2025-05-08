import java.io.*;
import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static int l;
    static int[][] dp;
    public int solution(int[][] info, int n, int m) {
        l = info.length;
        dp = new int[l + 1][m];
        // init
        for(int [] temp: dp){
            Arrays.fill(temp, INF);
        }
        dp[0][0] = 0;
        
        // logic
        for(int i = 0; i < l; i++){
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            for(int b = 0; b < m; b++){
                if(dp[i][b] == INF)continue;
                // A
                dp[i + 1][b] = Math.min(dp[i + 1][b], dp[i][b] + aTrace);       
                // B
                int newB = b + bTrace;
                if(newB < m){
                    dp[i + 1][newB] = Math.min(dp[i + 1][newB], dp[i][b]);
                }
            }
        }
        int answer = INF;
        for (int b = 0; b < m; b++) {
            if (dp[l][b] < n) {
                answer = Math.min(answer, dp[l][b]);
            }
        }
        return answer == INF ? -1 : answer;
    }
}