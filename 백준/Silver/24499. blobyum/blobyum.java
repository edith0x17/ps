import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int answer = sum;
        int l = 0, idx = k % n;
        for (int count = 0; count < n - 1; count++) {//n번인데 0번은 완료
            sum -= a[l];
            l = (l + 1) % n;

            sum += a[idx];
            idx = (idx + 1) % n;

            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}