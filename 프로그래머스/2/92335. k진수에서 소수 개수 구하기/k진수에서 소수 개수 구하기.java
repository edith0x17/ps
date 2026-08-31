import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] ss = s.split("0");
        for (String tmp : ss) {
            if (tmp.length() == 0) continue;
            if (check(tmp)) answer++;
        }
        return answer;
    }


    static boolean check(String s) {
        long num = Long.parseLong(s);
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}