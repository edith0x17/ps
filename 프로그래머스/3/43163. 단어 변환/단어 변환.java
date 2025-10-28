import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE)return 0;
        return answer;
    }
    static void dfs(String begin, String target, String[] words, int cnt){ //depth, visited
        if(answer <= cnt)return;
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visited[i])continue; //방문
            if(!check(begin, words[i]))continue; //장애물
            visited[i] = true;
            dfs(words[i], target, words, cnt + 1);
            visited[i] = false;
        }
    }
    static boolean check(String a, String b){ //한글자
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))cnt++;
        }
        return cnt == 1;
    }
}