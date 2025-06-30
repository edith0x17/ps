import java.io.*;
import java.util.*;

class Solution {
    static int k, n;
    static int[][] dungeons;
    static boolean[] visited;
    static int[][] ret;
    static int answer = -1;
    public int solution(int t, int[][] temp) {
        k = t;
        n = temp.length;
        dungeons = temp;
        visited = new boolean[n + 1];
        ret = new int[n + 1][2];
        dfs(0);
        return answer;
    }
    static void dfs(int depth){
        if(depth == n){
            int kTemp = k, cnt = 0;
            for(int i = 0; i < n; i++){
                if(kTemp >= ret[i][0]){
                    cnt++;
                    kTemp -= ret[i][1];
                }else break;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i])continue;
            visited[i] = true;
            ret[depth][0] = dungeons[i][0];
            ret[depth][1] = dungeons[i][1];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}