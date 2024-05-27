import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] a;
    static int m;
    static int flag, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            a[i] = temp == 1;
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            idx = Integer.parseInt(st.nextToken());

            go(flag, idx);
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] ? "1 " : "0 ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static void go(int flag, int idx) {
        if (flag == 1) { // 남자
            for (int i = idx; i <= n; i++) {
                if((i % idx) == 0){
                    a[i] = !a[i];
                }
            }
        } else { // 여자
            a[idx] = !a[idx];
            int i = 1;
            while (idx - i >= 1 && idx + i <= n) {
                if (a[idx - i] == a[idx + i]) {
                    a[idx - i] = !a[idx - i];
                    a[idx + i] = !a[idx + i];
                } else {
                    break;
                }
                i++;
            }
        }
    }
}