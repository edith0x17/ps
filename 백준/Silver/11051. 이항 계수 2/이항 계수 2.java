import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j<= k; j++){
                if(j == 0 || j == i)dp[i][j] = 1;
                else dp[i][j] = ((dp[i - 1][j - 1] % 10_007) + (dp[i - 1][j] % 10_007)) % 10_007;
            }
        }
        System.out.println(dp[n][k]);
    }
}