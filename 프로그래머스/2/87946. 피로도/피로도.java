import java.io.*;
import java.util.*;

class Solution {
    static int n, answer;
    static int[] ret;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        System.out.println(n);
        ret = new int[n];
        visited = new boolean[n];
        go(0, k, dungeons);
        return answer;
    }
    static int check(int k, int[][] dungeons){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(k >= dungeons[ret[i]][0]){
                cnt++;
                k -= dungeons[ret[i]][1];
            }
            else return cnt;
        }
        return cnt;
    }
    static void go(int depth, int k, int[][] dungeons){
        if(depth == n){
            answer = Math.max(answer, check(k, dungeons));
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            ret[depth] = i;
            visited[i] = true;
            go(depth + 1, k, dungeons);
            visited[i] = false;
        }
    }
}