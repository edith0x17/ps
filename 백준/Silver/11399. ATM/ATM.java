import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a, aSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        aSum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        aSum[0] = a[0];
        for (int i = 1; i < n; i++) {
            aSum[i] = a[i] + aSum[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += aSum[i];
        }
        System.out.println(ans);
    }
}