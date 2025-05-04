import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100_000; // diffs의 최대값으로 설정
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canClear(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean canClear(int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                total += times[i];
            } else {
                int prev = (i == 0 ? times[i] : times[i - 1]);
                long mistakeCount = diffs[i] - level;
                total += (long)(prev + times[i]) * mistakeCount + times[i];
            }

            if (total > limit) return false; // 조기 종료 최적화
        }
        return total <= limit;
    }
}
