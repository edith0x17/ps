// 40
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] ttt = today.split("\\.");
        int td = dayCal(ttt[0], ttt[1], ttt[2]);
        Map<String, Integer> mp = new HashMap<>();
        for(String s: terms){
            String[] ss = s.split(" ");//ss[0] ss[1]
            mp.put(ss[0], Integer.parseInt(ss[1]) * 28);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        int idx = 1;
        for(String s: privacies){
            String[] ss = s.split(" ");//ss[0](날짜) ss[1](알파벳)
            String[] tmp = ss[0].split("\\.");
            int day = dayCal(tmp[0], tmp[1], tmp[2]);
            if(day + mp.get(ss[1]) <= td)ret.add(idx);
            idx++;
        }
        int[] answer = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            answer[i] = ret.get(i);
        }
        return answer;
    }
    
    static int dayCal(String y, String m, String d){
        int yy = Integer.parseInt(y);
        int mm = Integer.parseInt(m);
        int dd = Integer.parseInt(d);
        return yy * 12 * 28 + mm * 28 + dd;
    }
}