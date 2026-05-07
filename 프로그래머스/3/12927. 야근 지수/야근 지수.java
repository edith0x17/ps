import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        for(int i: works){
            sum += (long)i;
        }
        if(sum <= n)return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);//내림차순
        for (int w : works) {
            pq.offer(w);
        }
        while(n > 0){
            int tmp = pq.poll();
            if(tmp - 1 == 0){
                n--;
                continue;
            }
            pq.offer(tmp - 1);
            n--;
        }
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
        return answer;
    }
}