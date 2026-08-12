import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timeTable) {
        String answer = "";
        int[] crew = new int[timeTable.length];
        for (int i = 0; i < timeTable.length; i++) {
            crew[i] = timeCal(timeTable[i]);
        }
        Arrays.sort(crew);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int busTime = 9 * 60 + i * t;
            int cnt = 0;
            while (idx < crew.length && crew[idx] <= busTime && cnt < m) {
                idx++;
                cnt++;
            }
            if (i == n - 1) {
                if (cnt < m) return String.format("%02d:%02d", busTime / 60, busTime % 60);
                else return String.format("%02d:%02d", (crew[idx - 1] - 1) / 60, (crew[idx - 1] - 1) % 60);
            }
        }

        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));

        return h * 60 + m;
    }
}