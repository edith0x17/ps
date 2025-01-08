import java.io.*;
import java.util.*;

public class Main{
    static int t, n;
    static int[][] arr, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            dp = new int[2][n + 1];
            StringTokenizer st = null;
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // init
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            // logic
            for(int i = 2; i <= n; i++){
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}