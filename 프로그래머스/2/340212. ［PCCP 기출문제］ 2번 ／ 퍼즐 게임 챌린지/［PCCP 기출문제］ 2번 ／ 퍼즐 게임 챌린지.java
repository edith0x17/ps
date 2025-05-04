class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int l = 1, r = 100_000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (go(diffs, times, limit, mid)) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    static boolean go(int[] diffs, int[] times, long limit, int level) {
        int n = diffs.length;
        long total = 0;

        for (int i = 0; i < n; i++) {
            if (level >= diffs[i]) {
                total += times[i];
            } else {
                if (i == 0) return false; // 첫 퍼즐에서 틀리는 경우는 말이 안됨
                long cnt = diffs[i] - level;
                total += (long)(times[i - 1] + times[i]) * cnt + times[i];
            }

            if (total > limit) return false; // 가지치기
        }

        return true;
    }
}
