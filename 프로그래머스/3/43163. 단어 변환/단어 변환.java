import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for(String word : words){
            if(target.equals(word))flag = true;
        }
        if(!flag)return 0;
        
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        return answer;
    }
    
    static boolean check(String a, String b){
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))cnt++;
        }
        return cnt == 1;
    }
    
    static void dfs(int cnt, String begin, String target, String[] words){
        if(answer <= cnt)return;
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visited[i])continue;
            if(!check(begin, words[i]))continue;
            visited[i] = true;
            dfs(cnt + 1, words[i], target, words);
            visited[i] = false;
        }
    }
}