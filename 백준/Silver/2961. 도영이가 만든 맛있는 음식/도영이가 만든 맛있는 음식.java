import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a, b;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int S = (1 << n);
        for (int i = 1; i < S; i++) {
            ArrayList<Integer> adj = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) adj.add(j);// 선택 O
                else continue;// 선택 X
            }
            int A = 1, B = 0;
            for (int j : adj) {
                A *= a[j];
                B += b[j];
            }
            answer = Math.min(answer, Math.abs(A - B));
        }
        System.out.println(answer);
    }
}