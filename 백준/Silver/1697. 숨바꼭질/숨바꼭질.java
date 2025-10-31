import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited = new int[100_004];
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        bfs(n);
        System.out.println(visited[k] - 1);
    }

    static void bfs(int here) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[here] = 1;
        q.offer(here);
        while (!q.isEmpty()) {
            here = q.poll();

            if (here == k) return;

            for (int there : new int[]{here - 1, here + 1, here * 2}) {
                if (there < 0 || there > 100_000) continue; //범위
                if (visited[there] != 0) continue; //방문
                visited[there] = visited[here] + 1;
                q.offer(there);
            }
        }
    }
}