import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int len = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        int start = 0, end = 0;
        while (true) {
            if (sum >= k) sum -= sequence[l++];
            else if (r == sequence.length) break;
            else sum += sequence[r++];//sum < k

            if (sum == k) {
                if (r - l < len) {
                    len = r - l;
                    answer = new int[]{l, r - 1};
                }
            }
        }
        return answer;
    }
}