import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = change(m);
        int mx = Integer.MIN_VALUE;
        for (String s : musicinfos) {
            String[] ss = s.split(",");
            int start = timeCal(ss[0]), end = timeCal(ss[1]);
            int playTime = end - start;
            String title = ss[2];
            String music = change(ss[3]);
            StringBuilder played = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                played.append(music.charAt(i % music.length()));
            }
            if (played.toString().contains(m)) {
                if (playTime > mx) {
                    mx = playTime;
                    answer = title;
                }
            }
        }
        if (answer.equals("")) return "(None)";
        return answer;
    }

    static String change(String s) {
        return s.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
}