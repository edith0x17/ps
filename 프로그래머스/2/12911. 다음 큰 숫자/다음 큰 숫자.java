import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = check(n);
        for (int i = n + 1; ; i++) {
            int b = check(i);
            if (a == b) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static int check(int n) {
        int ret = 1;
        while (n != 1) {
            if (n % 2 == 0) n = n / 2;
            else {
                ret++;
                n = n / 2;
            }
        }
        return ret;
    }
}