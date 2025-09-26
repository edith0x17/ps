import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long l = 1, r = (long) (5000 - 1) * (1 + Math.abs(1 - 1_000_000));
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean check(long k) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        visited[0] = true; //idx
        q.offer(0); //idx
        while (!q.isEmpty()) {
            int here = q.poll();

            if (here == n - 1) return true;

            for (int there = here + 1; there < n; there++) { //
                long cost = (long) (there - here) * (1 + Math.abs(a[here] - a[there]));
                if (cost <= k && !visited[there]) {
                    visited[there] = true;
                    q.offer(there);
                }
            }
        }
        return false;
    }
}