import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -(a - b));
        for(int i : priorities){
            pq.offer(i);
        }
        Queue<int[]> q = new ArrayDeque<>();
        int idx = 0;
        for(int i : priorities){
            q.offer(new int[]{i, idx++});//priorty, idx
        }
        int answer = 1;
        while(!pq.isEmpty()){
            int priority = pq.poll();
            
            boolean flag = false;
            while(true){
                int[] tmp = q.poll();
                if(tmp[0] == priority){
                    if(tmp[1] == location)flag = true;
                    break;
                }
                
                q.offer(tmp);
            }
            if(flag)break;
            
            answer++;
        }
        return answer;
    }
}