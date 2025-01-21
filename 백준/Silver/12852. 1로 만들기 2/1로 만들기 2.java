import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp, trace;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        trace = new int[n + 1];

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;  // update
                trace[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;  // update
                trace[i] = i / 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        while (n > 0) {
            sb.append(n).append(" ");
            n = trace[n];
        }
        System.out.println(sb);
    }
}