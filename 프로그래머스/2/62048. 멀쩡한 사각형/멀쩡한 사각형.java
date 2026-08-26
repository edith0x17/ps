import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h - ((long) w + h - gcd(w, h));
        return answer;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}