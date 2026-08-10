import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int ans = 0;
        int[] crew = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crew[i] = timeCal(timetable[i]);
        }
        Arrays.sort(crew);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int busTime = 9 * 60 + i * t, cnt = 0;
            while (idx < crew.length && crew[idx] <= busTime && cnt < m) {
                idx++;
                cnt++;
            }
            if (i == n - 1) {
                if (cnt < m) ans = busTime;
                else ans = crew[idx - 1] - 1;
            }
        }
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
}