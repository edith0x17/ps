import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a = new int[1030];
    static ArrayList<Integer>[] adj = new ArrayList[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 14; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (int)Math.pow(2, n) - 1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        go(0, (int) Math.pow(2, n) - 2, 1);
        for (int i = 1; i <= n; i++) {
            for (int j : adj[i]) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }

    static void go(int s, int e, int level) {
        if (s > e) return; //s <= e 일 때만 유효

        if (s == e) {
            adj[level].add(a[s]);
            return;
        }

        int mid = (s + e) / 2;
        adj[level].add(a[mid]);
        go(s, mid - 1, level + 1);
        go(mid + 1, e, level + 1);
    }
}