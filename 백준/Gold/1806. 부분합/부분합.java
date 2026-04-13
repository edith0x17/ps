import java.io.*;
import java.util.*;

public class Main {
    static int n, s, ans = Integer.MAX_VALUE;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, sum = 0;
        while (true) {
            if (sum >= s) {
                ans = Math.min(ans, r - l);
                sum -= a[l++];
            } else if (r == n) break;
            else if (sum < s) sum += a[r++];
        }
        if (ans != Integer.MAX_VALUE) System.out.println(ans);
        else System.out.println(0);
    }
}