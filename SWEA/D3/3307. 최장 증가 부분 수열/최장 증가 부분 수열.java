import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            dp = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = arr[0];
            int idx = 0;

            for (int i = 1; i < n; i++) {
                if (dp[idx] < arr[i]) {
                    dp[++idx] = arr[i];
                } else if (dp[idx] > arr[i]) {

                    int ii = lower_bound(dp, idx, arr[i]);
//                    int ii = lowerBound(dp, idx, arr[i]);

                    dp[ii] = arr[i];
                }

            }

            System.out.println("#" + tc + " " + (idx + 1));
        }
    }

    static int lower_bound(int[] dp, int end, int n) {
        int start = 0;

        while (start < end) {
            int mid = (start + end) / 2;
            if (dp[mid] >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

     static int lowerBound(int[] dp, int high, int n) {
        int low = 0;

        while (low < high) {
            int mid = low + (high)/2;

            if (n <= dp[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}