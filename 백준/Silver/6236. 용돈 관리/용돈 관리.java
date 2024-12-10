import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n, m, l, r, answer = Integer.MAX_VALUE;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        l = 0; r = 0;

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            l = Math.max(l, a[i]);
            r += a[i];
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 1, sum = mid;

            for (int i = 0; i < n; i++) {
                if (a[i] > mid) {
                    cnt = m + 1; // mid로는 해결 불가
                    break;
                }
                if (sum - a[i] >= 0) {
                    sum -= a[i];
                } else {
                    cnt++;
                    sum = mid - a[i];
                }
            }

            if (cnt > m) {
                l = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                r = mid - 1;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}