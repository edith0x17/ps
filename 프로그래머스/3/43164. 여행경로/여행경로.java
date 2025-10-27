import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<String> adj = new ArrayList<>();
    static boolean visited[];
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(adj);
        return adj.get(0).split(" ");
    }
    static void dfs(int depth, String here, String path, String[][] tickets){
        if(depth == tickets.length){
            adj.add(path);
            return; 
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && here.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}