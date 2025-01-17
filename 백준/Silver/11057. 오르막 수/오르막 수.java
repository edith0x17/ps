import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) { // i는 자리수
            for (int j = 0; j < 10; j++) { // j는 마지막 자리수
                for (int k = 0; k <= j; k++) { // k는 이전 자리수
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 10_007;
        }

        System.out.println(answer);
    }
}