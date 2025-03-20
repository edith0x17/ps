import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a, dp;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1
        dp[1][1] = a[1][1];
        for (int j = 2; j <= m; j++) {
            dp[1][j] = dp[1][j - 1] + a[1][j];
        }
        // ...
        for (int i = 2; i <= n; i++) {
            temp = new int[2][m + 1];

            // (왼쪽 vs 위에서 내려오는 값 비교)
            temp[0][1] = dp[i - 1][1] + a[i][1];// 첫 번째 열은 위에서만 온다.
            for (int j = 2; j <= m; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + a[i][j];
            }

            // (오른쪽 vs 위에서 내려오는 값 비교)
            temp[1][m] = dp[i - 1][m] + a[i][m];// 마지막 열은 위에서만 온다.
            for (int j = m - 1; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + a[i][j];
            }

            // 최댓값
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[n][m]);
    }
}