import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj, rev;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];   // 정방향
        rev = new ArrayList[n + 1];   // 역방향
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[f].add(t);
            rev[t].add(f);  // 역방향도 저장
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int smaller = dfs(i, adj) - 1; // 나보다 작은 학생 수

            visited = new boolean[n + 1];
            int bigger = dfs(i, rev) - 1;  // 나보다 큰 학생 수

            if (smaller + bigger == n - 1) answer++;
        }

        System.out.println(answer);
    }

    static int dfs(int here, ArrayList<Integer>[] graph) {
        int ret = 1;
        visited[here] = true;
        for (int there : graph[here]) {
            if (!visited[there]) {
                ret += dfs(there, graph);
            }
        }
        return ret;
    }
}