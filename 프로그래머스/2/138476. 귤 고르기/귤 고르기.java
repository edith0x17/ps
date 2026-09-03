import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : tangerine) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.offer(entry.getValue());
        }
        int cnt = 0;
        while (cnt < k) {
            cnt += pq.poll();
            answer++;
        }
        return answer;
    }
}