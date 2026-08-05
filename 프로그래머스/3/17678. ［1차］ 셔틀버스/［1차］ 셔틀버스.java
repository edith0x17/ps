import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] crew = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crew[i] = timeCal(timetable[i]);
        }
        Arrays.sort(crew);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int busTime = 540 + i * t;
            int cnt = 0;

            while (idx < crew.length && crew[idx] <= busTime && cnt < m) {//길이 
                idx++;
                cnt++;
            }
            if (i == n - 1) {
                if (cnt < m) return toTime(busTime);
                else return toTime(crew[idx - 1] - 1);
            }
        }
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static String toTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}