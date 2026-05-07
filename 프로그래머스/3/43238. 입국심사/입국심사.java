import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // “이 시간 안에 n명 처리 가능?”
        long answer = 0;
        Arrays.sort(times);
        long left = 1, right = (long) times[times.length - 1] * n;
        while (left <= right) {
            long mid = (left + right) / 2;
            //mid시간
            long cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }
            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}