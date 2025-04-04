import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c;
    static int[] a, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = new int[n];
        check = new int[d + 1];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int unique = 0;
        for (int i = 0; i < k; i++) {
            if (check[a[i]]++ == 0) unique++;// check[a[i]] == 0 -> check[a[i]]++
        }
        int answer = check[c] == 0 ? unique + 1 : unique;

        int idx = 0;
        for (int i = k; i < n + k; i++) {
            // 넣기
            int add = a[i % n];
            if (check[add]++ == 0) unique++;

            // 빼기
            int remove = a[idx++ % n];
            if (--check[remove] == 0) unique--;

            int temp = check[c] == 0 ? unique + 1 : unique;
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}