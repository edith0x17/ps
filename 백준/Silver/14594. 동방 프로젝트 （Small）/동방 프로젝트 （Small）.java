import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        m = Integer.parseInt(br.readLine());
        if (m == 0) {
            System.out.println(n);
            return;
        }
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = x; i < y; i++) {
                a[i]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 0) answer++;
        }
        System.out.println(answer);
    }
}