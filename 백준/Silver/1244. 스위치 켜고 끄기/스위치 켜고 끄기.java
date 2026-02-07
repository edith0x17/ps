import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] a;
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 1) a[i] = true;
            else a[i] = false;
        }
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 1) {//남
                for (int i = B; i <= n; i += B) {
                    a[i] = !a[i];
                }
            } else {//여
                int l = B - 1, r = B + 1;
                while (l >= 1 && r <= n && a[l] == a[r]) {//l >= 1
                    l--;
                    r++;
                }
                for (int i = l + 1; i < r; i++) {//l + 1, r - 1
                    a[i] = !a[i];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] ? "1 " : "0 ");
            if (i % 20 == 0) System.out.println();
        }
    }
}