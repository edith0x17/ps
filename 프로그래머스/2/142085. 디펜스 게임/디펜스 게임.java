import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : enemy) {
            pq.offer(i);
            n -= i;
            if (n < 0 && k > 0) {
                n += pq.poll();
                k--;
            }
            if (n < 0) break;
            answer++;
        }
        return answer;
    }
}