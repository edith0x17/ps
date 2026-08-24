import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        int idx = 0;
        for (long i = begin; i <= end; i++) {
            answer[idx++] = findNum(i);
        }
        return answer;
    }

    static int findNum(long num) {
        if (num == 1) return 0;
        int ret = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long big = num / i;
                if (big <= 10_000_000) return (int) big;
                ret = (int) i;
            }
        }
        return ret;
    }
}