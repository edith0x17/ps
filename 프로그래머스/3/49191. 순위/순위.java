import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj, rev;
    static boolean[] visited;
    public int solution(int n, int[][] results) {
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();   
        }
        rev = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            rev[i] = new ArrayList<>();           
        }
        for(int i = 0; i < results.length; i++){
            int f = results[i][0];
            int t = results[i][1];
            adj[t].add(f);
            rev[f].add(t);
        }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            int a = dfs(i, adj) - 1;
            int b = dfs(i, rev) - 1;
            if (a + b == n - 1) answer++;
        }
        return answer;
    }
    static int dfs(int here, ArrayList<Integer>[] graph){
        int ret = 1;
        visited[here] = true;
        for(int there: graph[here]){
            if(visited[there])continue;
            ret += dfs(there, graph);
        }
        return ret;
    }
}