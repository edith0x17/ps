import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        for(int i = 1; i <= n; i++){
            if(i == 1 || i == 2)dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}