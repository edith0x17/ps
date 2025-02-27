import java.io.*;
import java.util.*;

public class Main {
    static int n, k, MOD = 1_000_000_000;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i <= n; i++) {
                if (i == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        System.out.println(dp[n][k]);
    }
}