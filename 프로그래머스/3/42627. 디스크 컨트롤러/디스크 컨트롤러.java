import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);//요청 시간 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);//소요시간 짧은 순
        int idx = 0, time = 0, sum = 0, done = 0;
        while (done < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                sum += time - job[0];
                done++;
            }
        }
        return sum / jobs.length;
    }
}