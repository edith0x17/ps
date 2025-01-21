import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i == 2 || i == 3)dp[i] = 1;

            int mi = dp[i - 1] + 1;
            if(i % 3 == 0)mi = Math.min(mi, dp[i/ 3] + 1);
            if(i % 2 == 0)mi = Math.min(mi, dp[i/ 2] + 1);
            dp[i] = mi;
        }
        System.out.println(dp[n]);
    }
}