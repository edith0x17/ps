import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] arr, ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ret = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combi(0, 0);
        System.out.println(sb);
    }

    static void combi(int depth, int start) {
        if (depth == k) {
            for (int i : ret) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < n; i++) {
            if (arr[i] == prev) continue;//같은 depth에서 같은 수 선택X

            ret[depth] = arr[i];
            prev = arr[i];
            combi(depth + 1, i + 1);
        }
    }
}