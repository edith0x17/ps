import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static int[] visited;
    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new int[n + 1];
        for(int i = 0; i < edge.length; i++){
            //edge[i][0] edge[i][1]
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        bfs(1);
        int mx = 0, answer = 0;
        for(int i = 2; i <= n; i++){
            if(mx < visited[i]){
                mx = visited[i];
                answer = 1;
            }else if(mx == visited[i]){
                answer++;
            }
        }
        return answer;
    }
    static void bfs(int here){
        Queue<Integer> q = new ArrayDeque<>();
        visited[here] = 1;
        q.offer(here);
        while(!q.isEmpty()){
            here = q.poll();
            for(int there: adj[here]){
                if(visited[there] != 0)continue;
                visited[there] = visited[here] + 1;
                q.offer(there);
            }
        }
    }
}