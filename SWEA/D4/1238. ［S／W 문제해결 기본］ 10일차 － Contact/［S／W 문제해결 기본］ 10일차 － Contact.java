import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int n, s;
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            adj = new ArrayList[104];
            for (int i = 0; i < 104; i++) {
                adj[i] = new ArrayList<>();
            }
            visited = new int[104];

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
            }

            for (int i = 0; i < 104; i++) {
                Collections.sort(adj[i]);
            }

            bfs(s);

            int temp = -987654321;
            for(int i = 0; i < 104; i++){
                temp = Math.max(temp, visited[i]);
            }

            int ret = 0;
            for(int i = 0; i < 104; i++){
                if(temp == visited[i]){
                    ret = Math.max(ret, i);
                }
            }

            System.out.println("#" + tc + ' ' + ret);
        }
    }

//    static void dfs(int here){
//
//        visited[here] = true;
//        ret.add(here);
//        for(int there: adj[here]){
//            if(visited[there])continue;
//            dfs(there);
//        }
//    }

    static void bfs(int here) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[here] = 1;
        q.offer(here);
        while (!q.isEmpty()) {

            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                here = q.poll();

                for (int there : adj[here]) {
                    if (visited[there] != 0) continue;
                    visited[there] = visited[here] + 1;
                    q.offer(there);
                }
            }
        }
    }
}