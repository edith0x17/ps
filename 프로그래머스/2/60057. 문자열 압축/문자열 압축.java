import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length(), l = s.length();
        for (int i = 1; i <= l / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String tmp = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j < l; j += i) {
                int end = Math.min(j + i, l);
                String cur = s.substring(j, end);
                if (tmp.equals(cur)) {
                    cnt++;
                } else {
                    if (cnt >= 2) sb.append(cnt);
                    sb.append(tmp);

                    tmp = cur;
                    cnt = 1;
                }
            }
            if (cnt >= 2) sb.append(cnt);
            sb.append(tmp);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}