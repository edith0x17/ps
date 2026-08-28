import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = -1;

        m = change(m);

        for (String tmp : musicinfos) {
            String[] ss = tmp.split(",");
            int s = timeCal(ss[0]), e = timeCal(ss[1]);
            int playTime = e - s;

            String song = change(ss[3]);

            StringBuilder played = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                played.append(song.charAt(i % song.length()));
            }

            if (played.toString().contains(m)) {//노래.contains(m)
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = ss[2];//제목
                }
            }
        }

        if (answer.equals("")) return "(None)";
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));

        return h * 60 + m;
    }

    static String change(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}