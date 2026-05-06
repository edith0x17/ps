import java.util.*;

class Solution {
    public int solution(int[][] jobs) {//요청시간, 소요시간
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);//요청시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);//소요시간
        int idx = 0, time = 0, done = 0, sum = 0, n = jobs.length;
        while (done < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                done++;
                sum += time - job[0];
            }
        }
        return sum / n;
    }
}