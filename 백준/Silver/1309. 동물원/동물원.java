import java.io.*;
import java.util.*;

public class Main {
    static int dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];// dp[n][0] -> n행의 있지 않는 경우 dp[n][1] -> n행의 왼쪽에 있는 경우 dp[n][2] -> n행의 오른쪽에 있는 경우
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] % 9901 + dp[i - 1][1] % 9901 + dp[i - 1][2] % 9901) % 9901;
            dp[i][1] = (dp[i - 1][0] % 9901 + dp[i - 1][2] % 9901) % 9901;
            dp[i][2] = (dp[i - 1][0] % 9901 + dp[i - 1][1] % 9901) % 9901;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 9901);
    }
}