import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0, turn = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < t) {
            String s = Integer.toString(num, n).toUpperCase();
            for (int i = 0; i < s.length(); i++) {
                if (turn % m == p - 1) {
                    sb.append(s.charAt(i));
                    if (sb.length() == t) break;
                }
                turn++;
            }
            num++;
        }
        answer = sb.toString();
        return answer;
    }
}