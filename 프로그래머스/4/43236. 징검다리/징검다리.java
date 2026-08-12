import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int ans = 0;
        Arrays.sort(rocks);
        int l = 1, r = distance;
        while (l <= r) {
            int mid = (l + r) / 2;
            int prev = 0, cnt = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) cnt++;
                else prev = rocks[i];
            }
            if (distance - prev < mid) cnt++;
            if (cnt > n) {
                r = mid - 1;
            } else {//cnt <= n
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}