import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] a, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        a = new int[n + 4];
        dp = new int[n + 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = lisMaxSum();
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int lisMaxSum() {// 누적합
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            // dp[i] = 1;
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {  // 증가하는 부분 수열인지 확인
                    // d[i] = max(d[i], d[j] + 1);
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}