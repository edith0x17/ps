import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                if (dp[j - arr[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);// arr[i]를 사용 -> + 1 하는거
                }
            }
        }
        int answer = dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
        System.out.println(answer);
    }
}