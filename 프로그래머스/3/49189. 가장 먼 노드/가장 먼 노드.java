//59 -> 
import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static int[] visited;
    static int answer = 0;
    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new int[n + 1];
        for(int i = 0; i < edge.length; i++){
            int f = edge[i][0];
            int t = edge[i][1];
            adj[f].add(t); 
            adj[t].add(f); 
        }
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = 1;
        q.offer(1);
        while(!q.isEmpty()){
            int here = q.poll();
            
            for(int there: adj[here]){
                if(visited[there] != 0)continue;
                visited[there] = visited[here] + 1;
                q.offer(there);
            }
        }
        //System.out.println(Arrays.toString(visited));
        int mx = Integer.MIN_VALUE;
        for(int i = 1; i < n + 1; i++){
            mx = Math.max(mx, visited[i]);
        }
        for(int i = 1; i < n + 1; i++){
            if(mx == visited[i])answer++;
        }
        return answer;
    }
}