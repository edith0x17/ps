import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Data> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Data(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        while (!q.isEmpty()) {
            Data cur = q.poll();
            if (cur.priority < pq.peek()) {
                q.offer(cur);
                continue;
            }
            pq.poll();
            answer++;
            if (cur.idx == location) return answer;
        }
        return -1;
    }

    static class Data {
        int idx, priority;

        Data(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}