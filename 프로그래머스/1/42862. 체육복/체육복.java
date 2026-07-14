import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cnt = new int[n + 1];//-1, 0, 1
        for (int i : lost) {
            cnt[i]--;
        }
        for (int i : reserve) {
            cnt[i]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == -1) {
                if (i > 1 && cnt[i - 1] == 1) {
                    cnt[i - 1]--;
                    cnt[i]++;
                } else if (i < n && cnt[i + 1] == 1) {
                    cnt[i + 1]--;
                    cnt[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= 0) answer++;
        }
        return answer;
    }
}