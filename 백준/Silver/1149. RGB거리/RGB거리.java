import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] a = new int[1004][3], dp = new int[1004][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = a[0][0];
        dp[0][1] = a[0][1];
        dp[0][2] = a[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = a[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = a[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = a[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}