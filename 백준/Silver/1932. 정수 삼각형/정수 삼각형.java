import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [][] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        StringTokenizer st = null;
        for(int i = 1; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = arr[1][1];
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if (j == 1) {// 왼쪽
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == i) { // 오른쪽
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {// 가운데
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
                }
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            mx = Math.max(mx, dp[n][i]);
        }
        System.out.println(mx);
    }
}