import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited = new int[100_004];
    static int[] cnt = new int[100_004];
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited[n] = 1;
        cnt[n] = 1;
        q.offer(n);
        while (!q.isEmpty()) {
            int here = q.poll();
            for (int there : new int[]{here - 1, here + 1, here * 2}) {
                if (there < 0 || there > 100_000) continue;

                if (visited[there] == 0) {
                    visited[there] = visited[here] + 1;
                    cnt[there] = cnt[here];
                    q.offer(there);
                } else if (visited[there] == visited[here] + 1) {
                    cnt[there] += cnt[here];
                }
            }
        }
        System.out.println(visited[k] - 1);
        System.out.println(cnt[k]);
    }
}