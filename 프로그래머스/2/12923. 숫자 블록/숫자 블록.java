import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        int idx = 0;
        for (long i = begin; i <= end; i++) {
            answer[idx++] = (int) findNum(i);
        }
        return answer;
    }

    static long findNum(long num) {
        if (num == 1) return 0;
        int ret = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i <= 10_000_000) return num / i;
                ret = i;
            }
        }
        return ret;
    }
}