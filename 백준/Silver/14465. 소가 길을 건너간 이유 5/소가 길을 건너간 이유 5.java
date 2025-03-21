import java.io.*;
import java.util.*;

public class Main {
    static int n, k, b, answer = Integer.MAX_VALUE;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        a = new int[n + 1];
        Arrays.fill(a, 1);

        for (int i = 0; i < b; i++) {
            a[Integer.parseInt(br.readLine())] = 0;
        }

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += a[i];
        }
        answer = k - sum;
        for (int i = k + 1; i <= n; i++) {
            sum -= a[i - k];
            
            sum += a[i];
            answer = Math.min(answer, k - sum);
        }
        System.out.println(answer);
    }
}