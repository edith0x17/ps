import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new boolean[n + 1]; // 1-based index

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = st.nextToken().equals("1");
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) { // 남학생
                for (int j = num; j <= n; j += num) {
                    a[j] = !a[j];
                }
            } else { // 여학생
                a[num] = !a[num];
                int l = num - 1;
                int r = num + 1;
                while (l >= 1 && r <= n && a[l] == a[r]) {
                    a[l] = !a[l];
                    a[r] = !a[r];
                    l--;
                    r++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(a[i] ? "1 " : "0 ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}