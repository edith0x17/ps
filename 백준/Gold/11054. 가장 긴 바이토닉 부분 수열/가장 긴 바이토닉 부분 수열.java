import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr, lisLeftToRight, lisRightToLeft, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lisLeftToRight = new int[n]; // 왼쪽 → 오른쪽 LIS
        lisRightToLeft = new int[n]; // 오른쪽 → 왼쪽 LIS
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 → 오른쪽 LIS
        for (int i = 0; i < n; i++) {
            lisLeftToRight[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lisLeftToRight[i] = Math.max(lisLeftToRight[i], lisLeftToRight[j] + 1);
                }
            }
        }

        // 오른쪽 → 왼쪽 LIS
        for (int i = n - 1; i >= 0; i--) {
            lisRightToLeft[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    lisRightToLeft[i] = Math.max(lisRightToLeft[i], lisRightToLeft[j] + 1);
                }
            }
        }

        for(int i = 0; i < n; i++){
            dp[i] = lisLeftToRight[i] + lisRightToLeft[i] - 1;
        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, dp[i]);
        }
        sb.append(answer);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}