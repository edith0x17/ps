import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static boolean[] visited;
    static ArrayList<Integer> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(adj);
        System.out.println(adj.size());
        for (int i : adj) {
            System.out.println(i);
        }
    }

    static void dfs(int here, int start) {
        if (a[here] == start) {
            adj.add(start);
            return;
        }

        if (!visited[a[here]]) {
            visited[a[here]] = true;
            dfs(a[here], start);
            visited[a[here]] = false;
        }
    }
}