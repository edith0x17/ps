import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        for (int i = 0; i < n; i++) {
            long groupSize = factorial[n - 1 - i];
            int idx = (int) (k / groupSize);
            answer[i] = nums.get(idx);
            nums.remove(idx);
            k = k % groupSize;
        }
        return answer;
    }
}