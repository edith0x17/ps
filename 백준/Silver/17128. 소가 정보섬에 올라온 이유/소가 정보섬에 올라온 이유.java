import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static long[] a, p; // 배열, 구간배열
    static long s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        a = new long[n];
        p = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            p[i] = a[i] * a[(i + 1) % n] * a[(i + 2) % n] * a[(i + 3) % n]; //구간
            s += p[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;
            for (int d = 0; d < 4; d++) {
                int t = wrap(num - d);
                s -= 2 * p[t];
                p[t] = -p[t];
            }
            System.out.println(s);
        }
    }

    static int wrap(int x) {
        if (x < 0) return x + n;
        if (x >= n) return x - n;
        return x;
    }
}