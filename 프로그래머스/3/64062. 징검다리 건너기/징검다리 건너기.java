import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int l = 1, r = 0;
        for (int i : stones) {
            r = Math.max(r, i);
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            boolean flag = false;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] < mid) cnt++;
                else cnt = 0;
                
                if (cnt >= k) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}