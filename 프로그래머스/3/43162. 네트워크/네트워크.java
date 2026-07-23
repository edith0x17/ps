import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++){//0, 1, 2, 3, ...
            for(int j = 0; j < computers[i].length; j++){
                if(i == j)continue;
                if(computers[i][j] != 0)adj[i].add(j);//0, 1, 2, 3, 
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
            
        }
        for(int i = 0; i < n + 1; i++){
            System.out.print(i + " ");
            for(int j : adj[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        return answer;
    }
    
    static void dfs(int here){
        visited[here] = true;
        for(int there : adj[here]){
            if(visited[there])continue;
            dfs(there);
        }
        return;
    }
}