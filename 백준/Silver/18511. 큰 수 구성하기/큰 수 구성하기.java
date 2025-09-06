import java.io.*;
import java.util.*;

public class Main {
    static int n, k, l, answer;
    static int[] a, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String s = String.valueOf(n);
        l = s.length();
        a = new int[k];
        ret = new int[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= l; i++) {
            go(0, i);
        }
        System.out.println(answer);
    }

    static void go(int depth, int limit) {
        if (depth == limit) {
            if (ret[0] == 0) return; //X

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < limit; i++) {
                sb.append(ret[i]);
            }
            int temp = Integer.parseInt(sb.toString());
            if (temp <= n) {
                answer = Math.max(answer, temp);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            ret[depth] = a[i];
            go(depth + 1, limit);
        }
    }
}