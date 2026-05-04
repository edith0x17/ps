import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();//오름차순
        for (int i : scoville) {
            pq.offer((long) i);
        }
        while (pq.size() >= 2) {
            long first = pq.poll();
            if (first >= K) break;

            long second = pq.poll();
            long sum = first + second * 2;
            pq.offer(sum);
            answer++;
        }
        if (!pq.isEmpty() && pq.peek() >= K) return answer;
        return -1;
    }
}