import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 200_000;
    static int n, k;
    static int[] visited = new int[MAX + 1];
    static int[] prev = new int[MAX + 1];
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited[n] = 1;
        q.offer(n);
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) break;

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > MAX) continue;
                if (visited[next] != 0) continue;
                visited[next] = visited[now] + 1;
                prev[next] = now;
                q.offer(next);
            }
        }

        System.out.println(visited[k] - 1);

        Stack<Integer> stack = new Stack<>();
        for (int i = k; i != n; i = prev[i]) {
            stack.push(i);
        }
        stack.push(n);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}