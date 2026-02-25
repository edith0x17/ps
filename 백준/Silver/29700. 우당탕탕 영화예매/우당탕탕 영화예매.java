import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '0') a[i][j] = 0;
                else a[i][j] = 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (k > m) continue;

            int sum = 0, idx = 0;
            for (int j = 0; j < k; j++) {
                sum += a[i][j];
            }
            if (sum == 0) answer++;

            for (int j = k; j < m; j++) {
                sum -= a[i][idx++];
                sum += a[i][j];
                if (sum == 0) answer++;
            }
        }
        System.out.println(answer);
    }
}