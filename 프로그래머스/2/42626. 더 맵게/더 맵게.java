import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer((long) i);
        }
        while (pq.size() >= 2) {
            long first = pq.poll();
            if (first >= K) return answer;
            long second = pq.poll();
            long mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        }
        if (!pq.isEmpty() && pq.peek() >= K) return answer;
        return -1;//pq 1개 && < K
    }
}