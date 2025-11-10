import java.io.*;
import java.util.*;

public class Main {
    static int n, count;
    static int[] graph;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            System.out.println(n - count);
        }
    }

    static void dfs(int curr) {
        visited[curr] = true;
        int next = graph[curr];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            //사이클을 찾은 경우
            count++; //자기 자신 포함
            for (int i = next; i != curr; i = graph[i]) {
                count++;
            }
        }

        finished[curr] = true;
    }
}