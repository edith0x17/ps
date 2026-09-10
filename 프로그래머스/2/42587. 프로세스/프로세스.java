import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities) {
            pq.offer(i);
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }
        int cnt = 1;
        while (!pq.isEmpty()) {
            int target = pq.poll();
            boolean flag = false;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                if (tmp[1] == target) {
                    if (tmp[0] == location) {
                        answer = cnt;
                        flag = true;
                    }
                    break;
                }
                q.offer(tmp);
            }
            if(flag)break;
            cnt++;
        }
        return answer;
    }
}