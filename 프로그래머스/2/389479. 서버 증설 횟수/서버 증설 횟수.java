import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < 24; i++){
            int need = players[i]/ m;
            
            // 만료
            while(!q.isEmpty() && q.peek() <= i){
                q.poll();
            }
            
            // 현재
            int current = q.size();
            
            // 추가
            if(current < need){
                int newServer = need - current;
                
                answer += newServer;
                
                for (int j = 0; j < newServer; j++) {
                    q.offer(i + k);
                }   
            }
        }
        return answer;
    }
}